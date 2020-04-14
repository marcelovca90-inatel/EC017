'''
Created on 23 de ago de 2019

@author: marcelovca90
'''
import numpy as np
from _data import DataSets
from _math import ActivationFunctions
from _plot import PlotUtils

class Perceptron:

    def __init__(self):
        self.n = 1e-2 # learning rate
        self.g = ActivationFunctions.heaviside # activation function
        self.plot_data_x = [] # epochs for plotting
        self.plot_data_y = [] # error for plotting

    def train(self, x, d):
        k = len(x)
        w = np.random.rand(len(x[0]))
        epoch = 0
        error = True
        while error and epoch < 10000:
            error = False
            for i in range(0, k):
                v = np.dot(np.transpose(w), x[i])
                y = self.g(v)
                if y != d[i]:
                    w = np.add(w, np.multiply(self.n * (d[i] - y), x[i]))
                    error = True
            epoch = epoch + 1
            print('Epoch: {}\tWeights: {}'.format(epoch, w))
            self.plot_data_x.append(epoch)
            self.plot_data_y.append(1 if error else 0)
        return w

    def test(self, w, x):
        v = np.dot(np.transpose(w), x)
        y = self.g(v)
        return y
    
    def evaluate(self, w, x, d):
        correct = 0
        total = len(x)
        for i in range(0, len(x)):
            y = self.test(w, x[i])
            if (y == d[i]):
                correct = correct + 1
        accuracy = float(correct) / float(total)
        print('Accuracy: {:.2f}% ({}/{})'.format(100.0 * accuracy, correct, total))
        return accuracy

if  __name__ == '__main__':

    # set random number generator seed
    np.random.seed(42)

    # set floating point formatting when printing
    np.set_printoptions(formatter={'float': '{: 0.6f}'.format})

    # load data
    x = DataSets.LOGIC_GATE_AND.input
    d = DataSets.LOGIC_GATE_AND.output

    # create the neural network
    nn = Perceptron()

    # train the neural network
    w = nn.train(x, d)

    # evaluate the neural network
    acc = nn.evaluate(w, x, d)
    
    # plot epoch versus error data
    PlotUtils.plot(nn.plot_data_x, 'epoch', nn.plot_data_y, 'error')
