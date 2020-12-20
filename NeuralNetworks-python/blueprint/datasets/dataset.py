from . import utils


class Dataset:
  def __init__(self, name, path, input_type = float, output_type = float, bias = None):
    self.name = name
    self.path = path
    self.input_type = input_type
    self.output_type = output_type
    self.bias = bias

    self.input = utils.read(self.path / 'input.txt', dtype = self.input_type)
    self.output = utils.read(self.path / 'output.txt', dtype = self.output_type)

    if bias is not None:
      utils.bias(self.input, self.bias)
