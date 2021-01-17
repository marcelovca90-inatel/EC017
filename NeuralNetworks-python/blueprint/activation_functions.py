import numpy as np


def linear(x):
  return x

def gaussian(x, mu, sigma):
  return np.exp(-np.divide(np.square(x - mu), 2 * np.square(sigma)))

def heaviside(x):
  return 1 if x >= 0 else 0

def heaviside_symmetric(x):
  return np.sign(x)
