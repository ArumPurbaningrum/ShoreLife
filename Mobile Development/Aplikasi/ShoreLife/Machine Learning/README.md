# ShoreLife - Machine Learning Repository

## Introduction
In the machine learning repository, it consists of a model containing 10 fish classes. The model we use is Convolutional Neural Network. In addition, there are files used for the deployment process using Cloud Run.

## Machine Learning Team
- Angger Zufan Hanggara (M312BSY1734)
- Arifatul Eka Praditya (M312BSX0774)
- Khansa Duta Rismawan  (M312BSY0798)

## Our Steps
### Data Pre-Processing
This notebook outlines the necessary steps for data preparation and pre-processing before initiating the modeling process. To execute this notebook successfully, please adhere to the following steps:

1. Download the dataset utilized in this project from the provided link.
2. Upload the downloaded dataset to the same directory as this notebook within your environment.
3. Install the required libraries essential for running this notebook.

Once you have completed these steps, you can proceed to run the entire notebook, facilitating the pre-processing of the data before embarking on the modeling phase.

### Training Model
In this training section, contains several steps including:
1. Splitting the dataset into two folder for training and validation.
2. Create model architecture with GlobalAveragePooling2D, Dense, and Dropout.
3. Compile using the Adam optimizer and categorical crossentropy loss.
4. Set up callbacks to the model to create limitation epochs.
5. Plotting the accuracy into graphics.
6. Testing our model using fish image for every classes.
7. Save and convert the model into .h5 and .tflite format.


## Dataset
https://drive.google.com/drive/folders/14DbM-kcmvCqlHm-SCTpX_LADbwS5KJyL?usp=drive_link

### Dataset references
- Mark Daniel Lampa, Rose Claire Librojo, &amp; Mary Mae Calamba. (2022). <i>Fish Dataset</i> [Data set]. Kaggle. https://doi.org/10.34740/KAGGLE/DSV/4323384
- https://universe.roboflow.com/university-of-bengkulu-rwdy3/train_tuna
- https://universe.roboflow.com/itk15mei/thunnus_albacares
- https://universe.roboflow.com/abdelaziz-ashraf/shrimp-detection
- https://universe.roboflow.com/koreanfish2-v30jc/mackrel_1
- https://universe.roboflow.com/fishdetectionv2/fish_detection_silvercarp
- https://universe.roboflow.com/wael-afpe9/fast-sardine
