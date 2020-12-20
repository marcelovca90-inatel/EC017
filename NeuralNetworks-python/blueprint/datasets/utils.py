import numpy as np


def read(filename, delimiter = ',', dtype = float):
  return np.genfromtxt(filename, delimiter = delimiter, dtype = dtype)

def bias(x, value):
  biased_x = np.ndarray(shape = (x.shape[0], x.shape[1] + 1), dtype = x.dtype)

  for i in range(len(x)):
    biased_x[i] = np.append(value, x[i])

  return biased_x
