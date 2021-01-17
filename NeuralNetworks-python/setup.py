from distutils.util import convert_path
from setuptools import setup, find_packages


package_name = 'blueprint'
package_info = {}

with open(convert_path(f'{package_name}/package.py'), 'r') as file:
  exec(file.read(), package_info)

requirements = [
  'numpy>=1.18.0',
  'scipy>=1.5.4',
  'matplotlib>=3.3.0'
]

setup(
  name = package_name,
  version = package_info['__version__'],
  description = package_info['__description__'],
  author = package_info['__author__'],
  author_email = package_info['__email__'],
  license = package_info['__license__'],
  python_requires = '>=3.6.0',
  install_requires = requirements,
  packages = find_packages(),
  zip_safe = False)
