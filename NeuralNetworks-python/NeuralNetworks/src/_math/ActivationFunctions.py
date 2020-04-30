import numpy as np
import random as rnd

class ActivationFunctions:
    
    def __init__(self):
        pass

def heaviside(v):
    return 1 if v >= 0 else 0

def heaviside_symmetric(v):
    return np.sign(v)
