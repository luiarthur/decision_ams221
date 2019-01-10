Bayesian Decision Theory
================

Intro
=====

-   Formal framework for decision making under uncertainty.
-   Want to establish an *optimal* course of actions in a *probabilistic* setting.

Examples:
=========

Obtain an optimal decision
--------------------------

An oil company has to decide what to do with a promising field.

![\\theta = \\begin{cases} \\theta\_1 ~~ \\text{these is oil}\\\\ \\theta\_2 ~~ \\text{these is no oil}\\\\ \\end{cases}](https://latex.codecogs.com/png.latex?%5Ctheta%20%3D%20%5Cbegin%7Bcases%7D%20%5Ctheta_1%20~~%20%5Ctext%7Bthese%20is%20oil%7D%5C%5C%20%5Ctheta_2%20~~%20%5Ctext%7Bthese%20is%20no%20oil%7D%5C%5C%20%5Cend%7Bcases%7D "\theta = \begin{cases} \theta_1 ~~ \text{these is oil}\\ \theta_2 ~~ \text{these is no oil}\\ \end{cases}")

The consequences are to drill if ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1"), otherwise sell the field.

For the cost of ![C](https://latex.codecogs.com/png.latex?C "C") million ollars, the company can get a survey of the field.

The outcome ![X = \\begin{cases} \\text{presece of a certain formation} \\\\ \\text{absence of a certain formation} \\\\ \\end{cases}](https://latex.codecogs.com/png.latex?X%20%3D%20%5Cbegin%7Bcases%7D%20%5Ctext%7Bpresece%20of%20a%20certain%20formation%7D%20%5C%5C%20%5Ctext%7Babsence%20of%20a%20certain%20formation%7D%20%5C%5C%20%5Cend%7Bcases%7D "X = \begin{cases} \text{presece of a certain formation} \\ \text{absence of a certain formation} \\ \end{cases}")

| ![\\theta \\textbackslash x](https://latex.codecogs.com/png.latex?%5Ctheta%20%5Ctextbackslash%20x "\theta \textbackslash x") | 0   | 1   |
|------------------------------------------------------------------------------------------------------------------------------|-----|-----|
| ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1")                                                    | .2  | .8  |
| ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2")                                                    | .7  | .3  |

| ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") | ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1") | ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2") |
|--------------------------------------------------------------------|---------------------------------------------------------------------------|---------------------------------------------------------------------------|
|                                                                    | .6                                                                        | .4                                                                        |

| ![\\theta \\textbackslash a](https://latex.codecogs.com/png.latex?%5Ctheta%20%5Ctextbackslash%20a "\theta \textbackslash a") | ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1")    | ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2") |
|------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------|---------------------------------------------------------|
| ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1")                                                    | C ![-](https://latex.codecogs.com/png.latex?- "-") 5000    | C ![+](https://latex.codecogs.com/png.latex?%2B "+") 0  |
| ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2")                                                    | C ![+](https://latex.codecogs.com/png.latex?%2B "+") 20007 | C ![-](https://latex.codecogs.com/png.latex?- "-") 500  |

### Inference

Suppose you have a likelihood ![p(x\\mid \\theta)](https://latex.codecogs.com/png.latex?p%28x%5Cmid%20%5Ctheta%29 "p(x\mid \theta)") and a prior ![\\pi(\\theta)](https://latex.codecogs.com/png.latex?%5Cpi%28%5Ctheta%29 "\pi(\theta)"). Estimate ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta"), where ![\\theta \\in \\Theta](https://latex.codecogs.com/png.latex?%5Ctheta%20%5Cin%20%5CTheta "\theta \in \Theta") set of ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta")'s and ![a \\in A](https://latex.codecogs.com/png.latex?a%20%5Cin%20A "a \in A") set of actions.

Minimize ![{ \\text{E} }(L(\\theta, a) \\mid X) = \\int L(\\theta, a) p(\\theta\\mid X) d\\theta](https://latex.codecogs.com/png.latex?%7B%20%5Ctext%7BE%7D%20%7D%28L%28%5Ctheta%2C%20a%29%20%5Cmid%20X%29%20%3D%20%5Cint%20L%28%5Ctheta%2C%20a%29%20p%28%5Ctheta%5Cmid%20X%29%20d%5Ctheta "{ \text{E} }(L(\theta, a) \mid X) = \int L(\theta, a) p(\theta\mid X) d\theta").

### Hypothesis Testing - More broadly, model selection

The decisions are:

![p(x\\mid\\theta)](https://latex.codecogs.com/png.latex?p%28x%5Cmid%5Ctheta%29 "p(x\mid\theta)")

![L(\\theta, a) = \\begin{cases}
0 & ~ \\text{if } \\theta \\in \\Theta\_i \\\\
k\_i & ~ \\text{if } \\theta \\notin \\Theta\_i
\\end{cases}](https://latex.codecogs.com/png.latex?L%28%5Ctheta%2C%20a%29%20%3D%20%5Cbegin%7Bcases%7D%0A0%20%26%20~%20%5Ctext%7Bif%20%7D%20%5Ctheta%20%5Cin%20%5CTheta_i%20%5C%5C%0Ak_i%20%26%20~%20%5Ctext%7Bif%20%7D%20%5Ctheta%20%5Cnotin%20%5CTheta_i%0A%5Cend%7Bcases%7D "L(\theta, a) = \begin{cases}
0 & ~ \text{if } \theta \in \Theta_i \\
k_i & ~ \text{if } \theta \notin \Theta_i
\end{cases}")

Optimal Design - How to obtain the max amount of info with the min amount of effort
-----------------------------------------------------------------------------------

Network of NOAA stations. There is a need to reduce to half the stationsdue to budget constraints. Which ones should we take out?

Let ![d = { \\left\\{0, 0, 1, 1, \\dots, 0\\right\\} }](https://latex.codecogs.com/png.latex?d%20%3D%20%7B%20%5Cleft%5C%7B0%2C%200%2C%201%2C%201%2C%20%5Cdots%2C%200%5Cright%5C%7D%20%7D "d = { \left\{0, 0, 1, 1, \dots, 0\right\} }"), of length ![N](https://latex.codecogs.com/png.latex?N "N"). 0 for shut down station ![i](https://latex.codecogs.com/png.latex?i "i"), 1 for keep station ![i](https://latex.codecogs.com/png.latex?i "i") on. Space of actiosn is of size ![2^N](https://latex.codecogs.com/png.latex?2%5EN "2^N"). ![a = { \\left\\{d\\right\\} }](https://latex.codecogs.com/png.latex?a%20%3D%20%7B%20%5Cleft%5C%7Bd%5Cright%5C%7D%20%7D "a = { \left\{d\right\} }").

![y \\sim { \\mathcal{N} }(X\\beta, \\sigma^2 v(\\lambda))](https://latex.codecogs.com/png.latex?y%20%5Csim%20%7B%20%5Cmathcal%7BN%7D%20%7D%28X%5Cbeta%2C%20%5Csigma%5E2%20v%28%5Clambda%29%29 "y \sim { \mathcal{N} }(X\beta, \sigma^2 v(\lambda))") gives predictions of pollutants in the network. From this, I can produce predictions ![\\hat{y}\_i(y\_d)](https://latex.codecogs.com/png.latex?%5Chat%7By%7D_i%28y_d%29 "\hat{y}_i(y_d)"), location ![i](https://latex.codecogs.com/png.latex?i "i") using data at design ![d](https://latex.codecogs.com/png.latex?d "d").

Utility ![u(d, y) = K \\sum\_{i \\in d^c} \\mathbf{1}{ \\left\\{y\_i \\in \\hat y\_i(y\_d) \\pm \\delta\\right\\} } - \\sum\_{i \\in d} c\_i - C](https://latex.codecogs.com/png.latex?u%28d%2C%20y%29%20%3D%20K%20%5Csum_%7Bi%20%5Cin%20d%5Ec%7D%20%5Cmathbf%7B1%7D%7B%20%5Cleft%5C%7By_i%20%5Cin%20%5Chat%20y_i%28y_d%29%20%5Cpm%20%5Cdelta%5Cright%5C%7D%20%7D%20-%20%5Csum_%7Bi%20%5Cin%20d%7D%20c_i%20-%20C "u(d, y) = K \sum_{i \in d^c} \mathbf{1}{ \left\{y_i \in \hat y_i(y_d) \pm \delta\right\} } - \sum_{i \in d} c_i - C"). ![K](https://latex.codecogs.com/png.latex?K "K") chosen by econometricians.

Sequential Design
-----------------

![H\_0: \\theta \\in \\Theta\_0](https://latex.codecogs.com/png.latex?H_0%3A%20%5Ctheta%20%5Cin%20%5CTheta_0 "H_0: \theta \in \Theta_0"), ![H\_1: \\theta \\in \\Theta\_1](https://latex.codecogs.com/png.latex?H_1%3A%20%5Ctheta%20%5Cin%20%5CTheta_1 "H_1: \theta \in \Theta_1"). Three actions:

-   ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1"): Obtain new sample
-   ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2"): ![H\_0](https://latex.codecogs.com/png.latex?H_0 "H_0")
-   ![a\_3](https://latex.codecogs.com/png.latex?a_3 "a_3"): ![H\_1](https://latex.codecogs.com/png.latex?H_1 "H_1")

Statistical Controversies
-------------------------

1.  Judge an answer by
    -   what it says (Bayesian)
        -   This is the conditionality principle. Evidence from our experiment is taken at face value.
    -   how it was obtained
        -   We should consider all possible outcomes of the experiment.
2.  Probability lives
    -   in the world
        -   repeatability allows for measuring probabilities
    -   in the mind (Bayesian)
        -   probability is a construct that is context-dependent
3.  Learning requires
    -   models (statistics)
        -   easier to evaluate uncertainty
    -   algorithms (ML)
4.  Statisticians produce
    -   knowledge
        -   purely objective role
    -   solutions to problems
        -   involvement that accounst for context
