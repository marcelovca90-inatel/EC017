import numpy as np

from .estimator import Estimator


class Perceptron(Estimator):
  def __init__(self, learning_rate, activation_function, epochs):
    super().__init__()

    self.learning_rate = learning_rate
    self.activation_function = activation_function
    self.epochs = epochs

  def train(self, x, d):
    k = len(x)
    w = np.random.rand(len(x[0]))
    epoch = 0
    error = True

    print(f'Epoch: {epoch}\tWeights: {w}')

    self.plot_data_x.append(epoch)
    self.plot_data_y.append(1 if error else 0)

    while error and epoch < self.epochs:
      error = False

      for i in range(k):
        v = np.dot(np.transpose(w), x[i])
        y = self.activation_function(v)

        if y != d[i]:
          w = np.add(w, np.multiply(self.learning_rate * (d[i] - y), x[i]))
          error = True

      epoch = epoch + 1

      print(f'Epoch: {epoch}\tWeights: {w}')

      self.plot_data_x.append(epoch)
      self.plot_data_y.append(1 if error else 0)

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
