import numpy as np
import matplotlib.pyplot as plt

lines = np.loadtxt('result.txt')
x = lines[:,0]
ys = lines[:,1:]
ys = np.transpose(ys)
for y in ys:
    plt.plot(x, y)

plt.xlabel('Array Length')
plt.ylabel('Milliseconds')
plt.legend(['Algorithm 1', 'Algorithm 2', 'Algorithm 3', 'Algorithm 4'], loc=2)
plt.show()