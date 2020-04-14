'''
Created on 23 de ago de 2019

@author: marcelovca90
'''
import numpy as np
import os, sys
from numpy.random import sample
from numpy import append, genfromtxt

class DataSets:
    
    @staticmethod
    def read(folder, filename, flatten = False):
        filename_abs = os.path.join(os.path.dirname(__file__), folder, filename)
        return genfromtxt(filename_abs, delimiter=',', dtype=float)

    @staticmethod
    def add_bias(arr, bias = -1):
        biased_arr = np.ndarray(shape=(arr.shape[0], arr.shape[1]+1), dtype=float)
        for i in range(0, len(arr)):
            biased_arr[i] = np.append(bias, arr[i])
        return biased_arr

# https://en.wikipedia.org/wiki/AND_gate
class LOGIC_GATE_AND:
    input = DataSets.add_bias(DataSets.read('logic-gate-and', 'input.txt'))
    output = DataSets.read('logic-gate-and', 'output.txt', True)

# https://en.wikipedia.org/wiki/OR_gate
class LOGIC_GATE_OR:
    input = DataSets.add_bias(DataSets.read('logic-gate-or', 'input.txt'))
    output = DataSets.read('logic-gate-or', 'output.txt', True)

# https://en.wikipedia.org/wiki/XOR_gate
class LOGIC_GATE_XOR:
    input = DataSets.add_bias(DataSets.read('logic-gate-xor', 'input.txt'))
    output = DataSets.read('logic-gate-xor', 'output.txt', True)

# http://archive.ics.uci.edu/ml/datasets/Blood+Transfusion+Service+Center
class BLOOD_TRANSFUSION:
    input = DataSets.add_bias(DataSets.read('blood-transfusion', 'input.txt'))
    output = DataSets.read('blood-transfusion', 'output.txt', True)

# 
class DIABETES:
    input = DataSets.add_bias(DataSets.read('diabetes', 'input.txt'))
    output = DataSets.read('diabetes', 'output.txt', True)

# https://archive.ics.uci.edu/ml/datasets/Tic-Tac-Toe+Endgame
class TIC_TAC_TOE_ENDGAME:
    input = DataSets.add_bias(DataSets.read('tic-tac-toe-endgame', 'input.txt'))
    output = DataSets.read('tic-tac-toe-endgame', 'output.txt', True)
