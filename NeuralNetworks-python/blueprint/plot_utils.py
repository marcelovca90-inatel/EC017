import numpy as np
import matplotlib.pyplot as plt
from matplotlib.ticker import MaxNLocator


def line(x, y, x_label = 'x', y_label = 'y', color = 'blue', title = None):
  ax = plt.gca()
  ax.plot(x, y, color = color, linewidth = 1.5)
  ax.xaxis.set_major_locator(MaxNLocator(integer = True))

  ax.set_xlim([np.min(x), np.max(x)])
  ax.set_ylim([np.min(y), np.max(y)])

  ax.set_xlabel(x_label)
  ax.set_ylabel(y_label)
  ax.set_title('{} vs {}'.format(x_label, y_label) if title is None else title)

  ax.grid()
  plt.show()

def scatter(x, y, x_label = 'x', y_label = 'y', colors = None, title = None):
  ax = plt.gca()
  ax.scatter(x, y, c = colors, s = 10)
  ax.xaxis.set_major_locator(MaxNLocator(integer = True))

  ax.set_xlim([np.min(x), np.max(x)])
  ax.set_ylim([np.min(y), np.max(y)])

  ax.set_xlabel(x_label)
  ax.set_ylabel(y_label)
  ax.set_title('{} vs {}'.format(x_label, y_label) if title is None else title)

  ax.grid()
  plt.show()
