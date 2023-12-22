import os
os.environ['TF_CCP_MIN_LOG_LEVEL'] = '2'

import io
import tensorflow as tf 
from tensorflow import keras
import numpy as np
from PIL import Image

from flask import Flask, request, jsonify

model = keras.models.load_model('model.h5')
label = ["657fdec94a1e984c107e7354", "657fdec94a1e984c107e735c",
         "657fdec94a1e984c107e7355", "657fdec94a1e984c107e735a",
         "657fdec94a1e984c107e7356", "657fdec94a1e984c107e7358",
         "657fdec94a1e984c107e735b", "657fdec94a1e984c107e7357",
         "657fdec94a1e984c107e735d", "657fdec94a1e984c107e7359"]


def transform_image(pillow_image):
    data = np.asarray(pillow_image)
    data = data /255.0
    data = data[np.newaxis, ...]
    
    data = tf.image.resize(data,[224,224])
    
    return data

def predict(x):
    predictions = model(x)
    predictions = tf.nn.softmax(predictions)
    pred = predictions[0]
    label0 = label[np.argmax(pred)]
    return label0

app =  Flask(__name__)

@app.route("/predict", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        file = request.files.get('file')
        if file is None or file.filename == "":
            return jsonify({"error": "no file"})
        
        try: 
            image_bytes = file.read()
            pillow_img = Image.open(io.BytesIO(image_bytes)).convert('RGB')
            tensor = transform_image(pillow_img)
            prediction = predict(tensor)
            data = {"prediction": str(prediction)}
            return jsonify(data)
        except Exception as e:
            return jsonify({"error": str(e)})
        
    return "OK"


if __name__ == "__main__":
    app.run(debug=True)