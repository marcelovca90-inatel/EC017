import numpy as np
import os, sys
from numpy.random import sample
from numpy import append, genfromtxt

class DataSets:
    
    @staticmethod
    def read(folder, filename, flatten):
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
    input = DataSets.add_bias(DataSets.read('logic-gate-and', 'input.txt', False))
    output = DataSets.read('logic-gate-and', 'output.txt', True)

# https://en.wikipedia.org/wiki/OR_gate
class LOGIC_GATE_OR:
    input = DataSets.add_bias(DataSets.read('logic-gate-or', 'input.txt', False))
    output = DataSets.read('logic-gate-or', 'output.txt', True)

# https://en.wikipedia.org/wiki/XOR_gate
class LOGIC_GATE_XOR:
    input = DataSets.add_bias(DataSets.read('logic-gate-xor', 'input.txt', False))
    output = DataSets.read('logic-gate-xor', 'output.txt', True)

# http://archive.ics.uci.edu/ml/datasets/Blood+Transfusion+Service+Center
class BLOOD_TRANSFUSION:
    input = DataSets.add_bias(DataSets.read('blood-transfusion', 'input.txt', False))
    output = DataSets.read('blood-transfusion', 'output.txt', True)

# http://archive.ics.uci.edu/ml/datasets/Cryotherapy+Dataset+
class CRYOTHERAPY:
    input = DataSets.add_bias(DataSets.read('cryotherapy', 'input.txt', False))
    output = DataSets.read('cryotherapy', 'output.txt', True)

# https://www.kaggle.com/kumargh/pimaindiansdiabetescsv
class DIABETES:
    input = DataSets.add_bias(DataSets.read('diabetes', 'input.txt', False))
    output = DataSets.read('diabetes', 'output.txt', True)

# https://archive.ics.uci.edu/ml/datasets/Tic-Tac-Toe+Endgame
class TIC_TAC_TOE_ENDGAME:
    input = DataSets.add_bias(DataSets.read('tic-tac-toe-endgame', 'input.txt', False))
    output = DataSets.read('tic-tac-toe-endgame', 'output.txt', True)

# Conjunto de dado usado na NP1 de EC017 (2020 / 1o semestre) - questao 5
class NP1_BLOBS:
    input = DataSets.add_bias(DataSets.read('np1-blobs', 'input.txt', False))
    output = DataSets.read('np1-blobs', 'output.txt', True)

# Conjunto de dado usado na NP1 de EC017 (2020 / 1o semestre) - questao 6
class NP1_MOONS:
    input = DataSets.add_bias(DataSets.read('np1-moons', 'input.txt', False))
    output = DataSets.read('np1-moons', 'output.txt', True)

class FERNANDO:
    input = DataSets.add_bias(DataSets.read('fernando', 'input.txt', False))
    output = DataSets.read('fernando', 'output.txt', True)
