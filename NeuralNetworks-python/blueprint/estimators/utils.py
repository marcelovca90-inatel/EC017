import numpy as np
from scipy.special import comb


# https://stats.stackexchange.com/a/157385
def rand_index_score(y, d):
  tp_fp = comb(np.bincount(y), 2).sum()
  tp_fn = comb(np.bincount(d), 2).sum()

  A = np.c_[(y, d)]

  tp = sum(comb(np.bincount(A[A[:, 0] == i, 1]), 2).sum() for i in set(y))

  fp = tp_fp - tp
  fn = tp_fn - tp

  tn = comb(len(A), 2) - tp - fp - fn

  return (tp + tn) / (tp + fp + fn + tn)

# https://www.kdnuggets.com/2020/06/centroid-initialization-k-means-clustering.html
def kmeans_plus_plus(x, k):
  c = [x[0]]

  for _ in range(1, k):
    dist = np.array([min([np.inner(c - xi, c - xi) for c in c]) for xi in x])
    probs = dist / dist.sum()
    cumulative_probs = probs.cumsum()
    r = np.random.rand()

    for j, p in enumerate(cumulative_probs):
      if r < p:
        i = j
        break

    c.append(x[i])

  return np.array(c)
