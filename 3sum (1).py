#!/usr/bin/env python
# coding: utf-8

# In[ ]:





# In[2]:


import matplotlib.pyplot as plt# Updated input with additional values for quadratic and quadrithmic times
N = [250, 500, 1000, 2000, 4000, 8000, 16000]
quadratic_time = [2.901,2.546,7.691,30.11,138.753,610.819,3199.513]
quadrithmic_time = [2.636,3.938,20.201,101.067,464.071,2618.337,9012.193]
cubic_time = [5.688,35.094,268.386,2101.518,16663.997,None,None]

# For cubic time, we create a filtered list that excludes None values for plotting
filtered_N_cubic = [N[i] for i in range(len(N)) if cubic_time[i] is not None]
filtered_cubic_time = [time for time in cubic_time if time is not None]

plt.figure(figsize=(10, 6))
plt.grid(True, linestyle='--', alpha=0.6)
plt.title('Comparision of Different 3Sum Algorithms')
plt.xlabel('n')
plt.ylabel('Time (ms)')


plt.plot(N, quadratic_time, marker='o', label='Quadratic')
plt.plot(N, quadrithmic_time, marker='o', label='Quadrithmic')

# Plotting filtered data for cubic time (only up to N=4000)
plt.plot(filtered_N_cubic, filtered_cubic_time, marker='o', label='Cubic (N<=4000)')

plt.legend()
plt.show()


# In[3]:


import matplotlib.pyplot as plt

N = [250, 500, 1000, 2000, 4000, 8000, 16000]
quadratic_time = [2.901, 2.546, 7.691, 30.11, 138.753, 610.819, 3199.513]
quadrithmic_time = [2.636, 3.938, 20.201, 101.067, 464.071, 2618.337, 9012.193]
cubic_time = [5.688, 35.094, 268.386, 2101.518, 16663.997, None, None]

# For cubic time, we create a filtered list that excludes None values for plotting
filtered_N_cubic = [N[i] for i in range(len(N)) if cubic_time[i] is not None]
filtered_cubic_time = [time for time in cubic_time if time is not None]

plt.figure(figsize=(15, 6))

# Plot for Quadratic time
plt.subplot(1, 3, 1)
plt.grid(True, linestyle='--', alpha=0.6)
plt.title('Quadratic Time')
plt.xlabel('n')
plt.ylabel('Time (ms)')
plt.plot(N, quadratic_time, marker='o', color='blue')

# Plot for Quadrithmic time
plt.subplot(1, 3, 2)
plt.grid(True, linestyle='--', alpha=0.6)
plt.title('Quadrithmic Time')
plt.xlabel('n')
plt.ylabel('Time (ms)')
plt.plot(N, quadrithmic_time, marker='o', color='green')

# Plot for Cubic time (only up to N=4000)
plt.subplot(1, 3, 3)
plt.grid(True, linestyle='--', alpha=0.6)
plt.title('Cubic Time (N<=4000)')
plt.xlabel('n')
plt.ylabel('Time (ms)')
plt.plot(filtered_N_cubic, filtered_cubic_time, marker='o', color='red')

plt.tight_layout()
plt.show()


# In[ ]:


(/Rahul, Pothirendi)

