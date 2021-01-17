import numpy as np

from .estimator import Estimator


class Adaline(Estimator):
  def __init__(self, learning_rate, activation_function, loss_function, loss_variation_tolerance):
    super().__init__()

    self.learning_rate = learning_rate
    self.activation_function = activation_function
    self.loss_function = loss_function
    self.loss_variation_tolerance = loss_variation_tolerance

  def train(self, x, d):
    k = len(x)
    w = np.random.rand(len(x[0]))
    epoch = 0

    while True:
      mse_before = self.loss_function(x, d, w)

      if epoch == 0:
        print(f'Epoch: {epoch}\tWeights: {w}\tLoss: {mse_before:.5f}')

        self.plot_data_x.append(epoch)
        self.plot_data_y.append(mse_before)

      for i in range(k):
        v = np.dot(np.transpose(w), x[i])
        w = np.add(w, np.multiply(x[i], self.learning_rate * (d[i] - v)))

      epoch = epoch + 1
      mse_after = self.loss_function(x, d, w)

      print(f'Epoch: {epoch}\tWeights: {w}\tLoss: {mse_after:.5f}')

      self.plot_data_x.append(epoch)
      self.plot_data_y.append(mse_after)

      if abs(mse_after - mse_before) <= self.loss_variation_tolerance:
        break

    return w

  def predict(self, x, w):
    v = np.dot(np.transpose(w), x)
    y = self.activation_function(v)

    return y

  def evaluate(self, x, d, w):
    total = len(x)
    correct = 0

    for i in range(len(x)):
      y = self.predict(x[i], w)

      if y == d[i]:
        correct = correct + 1

    accuracy = correct / total

    print(f'Accuracy: {accuracy * 100:.5f}% ({accuracy:.5f})')

    return accuracy
