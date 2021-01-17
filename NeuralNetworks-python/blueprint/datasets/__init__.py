from pathlib import Path

from .dataset import Dataset
from .. import data


logic_gate_and = Dataset('logic_gate_and', Path(data.__file__).parent.resolve() / 'logic_gate_and', bias = -1)
logic_gate_or = Dataset('logic_gate_or', Path(data.__file__).parent.resolve() / 'logic_gate_or', bias = -1)
logic_gate_xor = Dataset('logic_gate_xor', Path(data.__file__).parent.resolve() / 'logic_gate_xor', bias = -1)
blood_transfusion = Dataset('blood_transfusion', Path(data.__file__).parent.resolve() / 'blood_transfusion', bias = -1)
cryotherapy = Dataset('cryotherapy', Path(data.__file__).parent.resolve() / 'cryotherapy', bias = -1)
diabetes = Dataset('diabetes', Path(data.__file__).parent.resolve() / 'diabetes', bias = -1)
tic_tac_toe_endgame = Dataset('tic_tac_toe_endgame', Path(data.__file__).parent.resolve() / 'tic_tac_toe_endgame', bias = -1)
tsne_2d = Dataset('tsne_2d', Path(data.__file__).parent.resolve() / 'tsne_2d', output_type = int)
