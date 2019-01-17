Bayesian Decision Theory - Decision Trees, Coherence & Dynamic Programing
================

Decision Trees
==============

Decision trees provide a pictorial representation of a sequential decision problem (dynamic programming).

Refer to oil drilling example (in `notes01`).

| ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") \\ ![x](https://latex.codecogs.com/png.latex?x "x") |    0|    1|
|------------------------------------------------------------------------------------------------------------------------|----:|----:|
| ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1")                                              |   .2|   .8|
| ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2")                                              |   .7|   .3|

| ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") |  ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1") (oil)|  ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2") (no oil)|
|--------------------------------------------------------------------|--------------------------------------------------------------------------------:|-----------------------------------------------------------------------------------:|
|                                                                    |                                                                               .6|                                                                                  .4|

The outcome ![X = \\begin{cases} \\text{presence of a certain formation} \\\\ \\text{absence of a certain formation} \\\\ \\end{cases}](https://latex.codecogs.com/png.latex?X%20%3D%20%5Cbegin%7Bcases%7D%20%5Ctext%7Bpresence%20of%20a%20certain%20formation%7D%20%5C%5C%20%5Ctext%7Babsence%20of%20a%20certain%20formation%7D%20%5C%5C%20%5Cend%7Bcases%7D "X = \begin{cases} \text{presence of a certain formation} \\ \text{absence of a certain formation} \\ \end{cases}")

| ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") \\ ![a](https://latex.codecogs.com/png.latex?a "a") |  ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1") (Drill)|  ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2") (Sell)|
|------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------:|---------------------------------------------------------------:|
| ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1")                                              |     ![-5000](https://latex.codecogs.com/png.latex?-5000 "-5000")|                ![0](https://latex.codecogs.com/png.latex?0 "0")|
| ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2")                                              |        ![2000](https://latex.codecogs.com/png.latex?2000 "2000")|       ![-500](https://latex.codecogs.com/png.latex?-500 "-500")|

A decision tree has two types of nodes.

-   `o` chance nodes that depend on random events
-   ![\\square](https://latex.codecogs.com/png.latex?%5Csquare "\square") decision nodes that depend on actions

You start the tree from the root that is placed at the left-hand side of the paper. The decision maker has three choices to start with.

1.  drill
2.  sell
3.  take the sample

<img src="img/img1.jpg" width="500" />

<img src="img/img2.jpg" width="500" />

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

Example 2
---------

Traveller considers crossing a mountain pass in the winter. The traveller can use a car or ride a train. There are uncertainties related to the state of the road and the possibility of an accident.

The decisions are

-   ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1") go by car
-   ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2") go by train

------------------------------------------------------------------------

-   If traveller takes the train, he will be either late or on time, but he will get there.
-   If traveller goes by car, the pass can be open or closed.
    -   If the pass is closed, he may return safely OR have an accident.
    -   If the pass is open, conditions may be good or bad.
        -   if the conditions are good, he may get to the appointment late or on time
        -   if the conditions are bad, he needs to consider the chances of having an accident

### Probabilities

-   ![\\Pr(\\text{pass open}) = 4/5](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Bpass%20open%7D%29%20%3D%204%2F5 "\Pr(\text{pass open}) = 4/5")
-   ![\\Pr(\\text{good conditions} \\mid \\text{pass open}) = 2/3](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Bgood%20conditions%7D%20%5Cmid%20%5Ctext%7Bpass%20open%7D%29%20%3D%202%2F3 "\Pr(\text{good conditions} \mid \text{pass open}) = 2/3")
-   ![\\Pr(\\text{late} \\mid \\text{good conditions}) = 1/20](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Blate%7D%20%5Cmid%20%5Ctext%7Bgood%20conditions%7D%29%20%3D%201%2F20 "\Pr(\text{late} \mid \text{good conditions}) = 1/20")
-   ![\\Pr(\\text{late} \\mid \\text{bad conditions}) = 1/4](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Blate%7D%20%5Cmid%20%5Ctext%7Bbad%20conditions%7D%29%20%3D%201%2F4 "\Pr(\text{late} \mid \text{bad conditions}) = 1/4")
-   ![\\Pr(\\text{accident} \\mid \\text{bad conditions}) = 1/16](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Baccident%7D%20%5Cmid%20%5Ctext%7Bbad%20conditions%7D%29%20%3D%201%2F16 "\Pr(\text{accident} \mid \text{bad conditions}) = 1/16")
-   ![\\Pr(\\text{accident} \\mid \\text{pass closed}) = 1/16](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Baccident%7D%20%5Cmid%20%5Ctext%7Bpass%20closed%7D%29%20%3D%201%2F16 "\Pr(\text{accident} \mid \text{pass closed}) = 1/16")
-   ![\\Pr(\\text{train late}) = 1/10](https://latex.codecogs.com/png.latex?%5CPr%28%5Ctext%7Btrain%20late%7D%29%20%3D%201%2F10 "\Pr(\text{train late}) = 1/10")

### Utilities (usually also Negative Losses)

We consider three aspects of the problem. Utilities in parenthesis. ![U \\ge 0](https://latex.codecogs.com/png.latex?U%20%5Cge%200 "U \ge 0").

-   Arrival Time
    -   on time (+15)
    -   late (+12)
    -   no arrival (0)
-   Journey Quality
    -   good (+5)
    -   indifferent (+2)
    -   bad (0)
-   Possibility of Accident
    -   yes (0)
    -   no (+10)

<img src="img/img4.jpg" width="500" />

Elements of a Decision Problem
------------------------------

-   **state of nature**: ![\\theta \\in \\Theta](https://latex.codecogs.com/png.latex?%5Ctheta%20%5Cin%20%5CTheta "\theta \in \Theta")
-   **actions**: ![a \\in { \\mathcal{A} }](https://latex.codecogs.com/png.latex?a%20%5Cin%20%7B%20%5Cmathcal%7BA%7D%20%7D "a \in { \mathcal{A} }") (aka decisions)
-   **Loss function**: ![L(\\theta, a)](https://latex.codecogs.com/png.latex?L%28%5Ctheta%2C%20a%29 "L(\theta, a)") (negative utility)
-   **Statistical evidence** ![X \\in { \\mathcal{X} }](https://latex.codecogs.com/png.latex?X%20%5Cin%20%7B%20%5Cmathcal%7BX%7D%20%7D "X \in { \mathcal{X} }") (data)
-   **Experiment**: ![e \\in \\mathcal{E}](https://latex.codecogs.com/png.latex?e%20%5Cin%20%5Cmathcal%7BE%7D "e \in \mathcal{E}") (![n \\in \\mathbb{N}](https://latex.codecogs.com/png.latex?n%20%5Cin%20%5Cmathbb%7BN%7D "n \in \mathbb{N}"))

The complete scheme looks like:

<img src="img/img3.jpg" width="500" />

Bets
----

![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") is the indicator of an event. Fisher wins a tennis match against Neyman. A bet is a ticket that will be worth ![S](https://latex.codecogs.com/png.latex?S "S") (stakes) if ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") occurs, and 0 otherwise. The ticket costs ![\\pi\_\\theta S](https://latex.codecogs.com/png.latex?%5Cpi_%5Ctheta%20S "\pi_\theta S"). ![\\frac{\\pi\_\\theta}{1-\\pi\_\\theta}](https://latex.codecogs.com/png.latex?%5Cfrac%7B%5Cpi_%5Ctheta%7D%7B1-%5Cpi_%5Ctheta%7D "\frac{\pi_\theta}{1-\pi_\theta}") are the betting odds in favor of ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta"). The payoffs for the action of buying a ticket are:

| ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta")             |                                                                                   0|                                                                     1|
|--------------------------------------------------------------------------------|-----------------------------------------------------------------------------------:|---------------------------------------------------------------------:|
| Buy bet on ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta")  |   ![(1-\\pi) S](https://latex.codecogs.com/png.latex?%281-%5Cpi%29%20S "(1-\pi) S")|  ![-\\pi S](https://latex.codecogs.com/png.latex?-%5Cpi%20S "-\pi S")|
| Sell bet on ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") |  -![(1-\\pi) S](https://latex.codecogs.com/png.latex?%281-%5Cpi%29%20S "(1-\pi) S")|     ![\\pi S](https://latex.codecogs.com/png.latex?%5Cpi%20S "\pi S")|

Dutch Book (Arbitrage)
----------------------

Suppose a bookmaker posts the price ![0.2](https://latex.codecogs.com/png.latex?0.2 "0.2") for bets on the event "Fisher wins", and the price ![0.7](https://latex.codecogs.com/png.latex?0.7 "0.7") for bets on "Neyman wins". Suppose you place both bets.

|           |                                                        Fisher wins|                                                           Neyman wins|
|-----------|------------------------------------------------------------------:|---------------------------------------------------------------------:|
| Bet 1     |  ![0.85 S](https://latex.codecogs.com/png.latex?0.85%20S "0.85 S")|  ![-0.25 S](https://latex.codecogs.com/png.latex?-0.25%20S "-0.25 S")|
| Bet 2     |  ![-0.7 S](https://latex.codecogs.com/png.latex?-0.7%20S "-0.7 S")|        ![0.3 S](https://latex.codecogs.com/png.latex?0.3%20S "0.3 S")|
| Both bets |     ![0.1 S](https://latex.codecogs.com/png.latex?0.1%20S "0.1 S")|        ![0.1 S](https://latex.codecogs.com/png.latex?0.1%20S "0.1 S")|

You make ![0.1 S](https://latex.codecogs.com/png.latex?0.1%20S "0.1 S") **for sure** if you place both bets.

Coherence
---------

A set of betting odds is **coherent** if no combination of bets produces sure losses.

Assumptions:

1.  The odds are fair. The bookmaker is willing to both sell and buy any bets.
2.  There is no restriction in the number of bets that can be placed. And they are all equally valuable.

**Theorem**: Under assumptions 1 and 2 (above), a necessary condition for a set of prices to be coherent is that they satisfy Kolmogorov axioms.

-   Axiom 1: ![0 \\le \\pi\_\\theta \\le 1, ~ \\forall \\theta](https://latex.codecogs.com/png.latex?0%20%5Cle%20%5Cpi_%5Ctheta%20%5Cle%201%2C%20~%20%5Cforall%20%5Ctheta "0 \le \pi_\theta \le 1, ~ \forall \theta")
-   Axiom 2: ![0 \\pi\_\\Theta = 1](https://latex.codecogs.com/png.latex?0%20%5Cpi_%5CTheta%20%3D%201 "0 \pi_\Theta = 1") where ![\\Theta](https://latex.codecogs.com/png.latex?%5CTheta "\Theta") is the sure event
-   Axiom 3: If ![\\theta\_!](https://latex.codecogs.com/png.latex?%5Ctheta_%21 "\theta_!") and ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2") are such that ![\\theta\_1\\theta\_2 = 0](https://latex.codecogs.com/png.latex?%5Ctheta_1%5Ctheta_2%20%3D%200 "\theta_1\theta_2 = 0"), then ![\\pi\_{\\theta\_1} + \\pi\_{\\theta\_2} = \\pi\_{\\theta\_1 + \\theta\_2}](https://latex.codecogs.com/png.latex?%5Cpi_%7B%5Ctheta_1%7D%20%2B%20%5Cpi_%7B%5Ctheta_2%7D%20%3D%20%5Cpi_%7B%5Ctheta_1%20%2B%20%5Ctheta_2%7D "\pi_{\theta_1} + \pi_{\theta_2} = \pi_{\theta_1 + \theta_2}")

**Proof**: See Parmigiani & Inoue p.19

Coherent Conditional Probabilities
----------------------------------

See Parmigiani & Inoue p.20 - 21

Utility (Chapter 3)
===================

-   St. Peterburg Paradox
    -   How do we value payoffs that are subject to uncertainty What is the fair price of a bet? The answer to that question is expected utility.
        -   fair value `<->` expected utility
