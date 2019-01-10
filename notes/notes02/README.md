Bayesian Decision Theory - Decision Trees, Coherence & Dynamic Programing
================

Decision Trees
==============

Decision trees provide a pictorial representation of a sequential decision problem (dynamic programming).

Refer to oil drilling example (in `notes01`).

| ![\\theta {\\textbackslash}x](https://latex.codecogs.com/png.latex?%5Ctheta%20%7B%5Ctextbackslash%7Dx "\theta {\textbackslash}x") | 0   | 1   |
|-----------------------------------------------------------------------------------------------------------------------------------|-----|-----|
| ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1")                                                         | .2  | .8  |
| ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2")                                                         | .7  | .3  |

| ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") | ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1") (oil) | ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2") (no oil) |
|--------------------------------------------------------------------|---------------------------------------------------------------------------------|------------------------------------------------------------------------------------|
|                                                                    | .6                                                                              | .4                                                                                 |

The outcome ![X = \\begin{cases} \\text{presence of a certain formation} \\\\ \\text{absence of a certain formation} \\\\ \\end{cases}](https://latex.codecogs.com/png.latex?X%20%3D%20%5Cbegin%7Bcases%7D%20%5Ctext%7Bpresence%20of%20a%20certain%20formation%7D%20%5C%5C%20%5Ctext%7Babsence%20of%20a%20certain%20formation%7D%20%5C%5C%20%5Cend%7Bcases%7D "X = \begin{cases} \text{presence of a certain formation} \\ \text{absence of a certain formation} \\ \end{cases}")

| ![\\theta \\textbackslash a](https://latex.codecogs.com/png.latex?%5Ctheta%20%5Ctextbackslash%20a "\theta \textbackslash a") | ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1") (Drill) | ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2") (Sell) |
|------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|----------------------------------------------------------------|
| ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1")                                                    | ![-](https://latex.codecogs.com/png.latex?- "-") 5000           | 0                                                              |
| ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2")                                                    | 2000                                                            | ![-](https://latex.codecogs.com/png.latex?- "-") 500           |

A decision tree has two types of nodes.

-   `o` chance nodes that depend on random events
-   ![\\square](https://latex.codecogs.com/png.latex?%5Csquare "\square") decision nodes that depend on actions

You start the tree from the root that is placed at the left-hand side of the paper. The decision maker has three choices to start with.

1.  drill
2.  sell
3.  take the sample

INSERT GRAPH 1

![\\begin{split}
\\Pr(X=1)&=\\Pr(X=1\\mid\\theta\_1) \\Pr(\\theta\_1) + \\Pr(X=1\\mid\\theta\_2) \\Pr(\\theta\_2)= (.8)(.6) + (.3)(.4) = .6 \\\\
\\Pr(X=0)&=\\Pr(X=0\\mid\\theta\_1) \\Pr(\\theta\_1) + \\Pr(X=0\\mid\\theta\_2) \\Pr(\\theta\_2)= .4 \\\\
\\\\
\\Pr(\\theta\_1\\mid X=1)&=\\Pr(X=1\\mid\\theta\_1) \\Pr(\\theta\_1) / \\Pr(X=1) = .8\\\\
\\Pr(\\theta\_2\\mid X=0)&=\\Pr(X=0\\mid\\theta\_2) \\Pr(\\theta\_2) / \\Pr(X=0) = .7\\\\
\\end{split}](https://latex.codecogs.com/png.latex?%5Cbegin%7Bsplit%7D%0A%5CPr%28X%3D1%29%26%3D%5CPr%28X%3D1%5Cmid%5Ctheta_1%29%20%5CPr%28%5Ctheta_1%29%20%2B%20%5CPr%28X%3D1%5Cmid%5Ctheta_2%29%20%5CPr%28%5Ctheta_2%29%3D%20%28.8%29%28.6%29%20%2B%20%28.3%29%28.4%29%20%3D%20.6%20%5C%5C%0A%5CPr%28X%3D0%29%26%3D%5CPr%28X%3D0%5Cmid%5Ctheta_1%29%20%5CPr%28%5Ctheta_1%29%20%2B%20%5CPr%28X%3D0%5Cmid%5Ctheta_2%29%20%5CPr%28%5Ctheta_2%29%3D%20.4%20%5C%5C%0A%5C%5C%0A%5CPr%28%5Ctheta_1%5Cmid%20X%3D1%29%26%3D%5CPr%28X%3D1%5Cmid%5Ctheta_1%29%20%5CPr%28%5Ctheta_1%29%20%2F%20%5CPr%28X%3D1%29%20%3D%20.8%5C%5C%0A%5CPr%28%5Ctheta_2%5Cmid%20X%3D0%29%26%3D%5CPr%28X%3D0%5Cmid%5Ctheta_2%29%20%5CPr%28%5Ctheta_2%29%20%2F%20%5CPr%28X%3D0%29%20%3D%20.7%5C%5C%0A%5Cend%7Bsplit%7D "\begin{split}
\Pr(X=1)&=\Pr(X=1\mid\theta_1) \Pr(\theta_1) + \Pr(X=1\mid\theta_2) \Pr(\theta_2)= (.8)(.6) + (.3)(.4) = .6 \\
\Pr(X=0)&=\Pr(X=0\mid\theta_1) \Pr(\theta_1) + \Pr(X=0\mid\theta_2) \Pr(\theta_2)= .4 \\
\\
\Pr(\theta_1\mid X=1)&=\Pr(X=1\mid\theta_1) \Pr(\theta_1) / \Pr(X=1) = .8\\
\Pr(\theta_2\mid X=0)&=\Pr(X=0\mid\theta_2) \Pr(\theta_2) / \Pr(X=0) = .7\\
\end{split}")
