class Estimator:
  def __init__(self, *args, **kwargs):
    if type(self) is Estimator:
      raise NotImplementedError

    self.plot_data_x = []
    self.plot_data_y = []

  def train(self, *args, **kwargs):
    raise NotImplementedError

  def predict(self, *args, **kwargs):
    raise NotImplementedError

  def evaluate(self, *args, **kwargs):
    raise NotImplementedError
