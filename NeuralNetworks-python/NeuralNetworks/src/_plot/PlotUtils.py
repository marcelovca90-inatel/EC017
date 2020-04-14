'''
Created on 21 de set de 2018

@author: marcelocysneiros
'''
import matplotlib.pyplot as plt
from matplotlib.ticker import MaxNLocator
import datetime as dt
import numpy as np

class PlotUtils:
    
    def __init__(self):
        pass
    
# https://matplotlib.org/api/axes_api.html#matplotlib.axes.Axes
def plot(x, _xlabel, y, _ylabel):
    
    # handle convergence in first training epoch
    if len(x) == 1 and len(y) == 1:
        print('Only one training epoch was performed; no plot to show.')
    else:
        # data
        ax = plt.gca()
        ax.plot(x, y, color='blue', linewidth=1.5)
        ax.xaxis.set_major_locator(MaxNLocator(integer=True))
        
        # limits
        ax.set_xlim([np.min(x), np.max(x)])
        ax.set_ylim([np.min(y), np.max(y)])
        
        # text
        ax.set_xlabel(_xlabel)
        ax.set_ylabel(_ylabel)
        ax.set_title('{} vs {}'.format(_xlabel, _ylabel))
        
        # display
        ax.grid()
        plt.show()
