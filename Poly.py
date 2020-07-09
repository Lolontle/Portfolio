import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures
# Training set
x_train = [[4], [6], [8], [10], [12]] # Different ages
y_train = [[10], [12], [15], [17], [20]] # Different allowances
# Testing set
x_test = [[7], [13], [14], [16]] # Different ages
y_test = [[13], [22], [26], [30]] # Different allowances

# Train the Linear Regression model and plot a prediction
regressor = LinearRegression()
regressor.fit(x_train, y_train)
xx = np.linspace(0, 26, 100)
yy = regressor.predict(xx.reshape(xx.shape[0], 1))
plt.plot(xx, yy)

# Set the degree of the Polynomial Regression model
quadratic_featurizer = PolynomialFeatures(degree = 2)

# This preprocessor transforms an input data matrix into a new data matrix
x_train_quadratic = quadratic_featurizer.fit_transform(x_train)
x_test_quadratic = quadratic_featurizer.transform(x_test)

# Train and test the regressor_quadratic model
regressor_quadratic = LinearRegression()
regressor_quadratic.fit(x_train_quadratic, y_train)
xx_quadratic = quadratic_featurizer.transform(xx.reshape(xx.shape[0], 1))

#Plot the graph
plt.plot(xx, regressor_quadratic.predict(xx_quadratic), c = 'b', linestyle = '--')
plt.title('Allowance at different ages')
plt.xlabel('Age in years')
plt.ylabel('Allowances in Rands')
plt.axis([0, 35, 0, 35])
plt.grid(True)
plt.scatter(x_train, y_train)
plt.show()

print (x_train)
print (X_train_quadratic)
print (x_test)
print (X_test_quadratic)
