#fileio by Pannapat Panpakdee

I ran this task on MacBook Air, and got these results:

|Task			              | Time
|-----------------------|-----------:
|Copy the file one byte at a time | 2.089328 sec
|Copy the file using a byte array of size 1 KB | 0.010620 sec
|Copy the file using a byte array of size 4 KB | 0.002230 sec
|Copy the file using a byte array of size 64 KB | 0.001209 sec
|Copy the file using a BufferedReader and PrintWriter to copy lines of text |0.221560 sec
|Copy a file by using BufferedReader and BufferedWriter with a array of char | 0.20302 sec
