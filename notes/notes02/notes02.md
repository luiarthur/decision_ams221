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

Expected Utility Principle
==========================

See Parmigiani & Inoue p.40

-   define a set of outcomes on rewards ![Z](https://latex.codecogs.com/png.latex?Z "Z")
-   define a set of states of the world ![\\Theta](https://latex.codecogs.com/png.latex?%5CTheta "\Theta")
-   An action is a function mapping ![\\Theta](https://latex.codecogs.com/png.latex?%5CTheta "\Theta") to ![Z](https://latex.codecogs.com/png.latex?Z "Z"), ![a: \\Theta \\rightarrow Z](https://latex.codecogs.com/png.latex?a%3A%20%5CTheta%20%5Crightarrow%20Z "a: \Theta \rightarrow Z")
-   ![{ \\mathcal{A} }](https://latex.codecogs.com/png.latex?%7B%20%5Cmathcal%7BA%7D%20%7D "{ \mathcal{A} }") is the set of all possible actions
-   we want to produce a function ![U(z)](https://latex.codecogs.com/png.latex?U%28z%29 "U(z)") that measures the utility of rewards ![z](https://latex.codecogs.com/png.latex?z "z")
-   probabilities of states of the world ![\\theta](https://latex.codecogs.com/png.latex?%5Ctheta "\theta") are distributions ![\\pi(\\theta)](https://latex.codecogs.com/png.latex?%5Cpi%28%5Ctheta%29 "\pi(\theta)")

We can think of actions as probability distributions over rewards:

![p(z) = \\int\_{\\theta: a(\\theta)=z} \\pi(\\theta) d\\theta](https://latex.codecogs.com/png.latex?p%28z%29%20%3D%20%5Cint_%7B%5Ctheta%3A%20a%28%5Ctheta%29%3Dz%7D%20%5Cpi%28%5Ctheta%29%20d%5Ctheta "p(z) = \int_{\theta: a(\theta)=z} \pi(\theta) d\theta")

The utility of an action is

![u\_{\\pi}(a) = \\int\_\\Theta u(a(\\theta)) \\pi(\\theta)d\\theta](https://latex.codecogs.com/png.latex?u_%7B%5Cpi%7D%28a%29%20%3D%20%5Cint_%5CTheta%20u%28a%28%5Ctheta%29%29%20%5Cpi%28%5Ctheta%29d%5Ctheta "u_{\pi}(a) = \int_\Theta u(a(\theta)) \pi(\theta)d\theta")

Assuming ![z](https://latex.codecogs.com/png.latex?z "z") is finite,

![u\_{\\pi}(a) = \\sum\_{z\\in Z} p(z) u(z)](https://latex.codecogs.com/png.latex?u_%7B%5Cpi%7D%28a%29%20%3D%20%5Csum_%7Bz%5Cin%20Z%7D%20p%28z%29%20u%28z%29 "u_{\pi}(a) = \sum_{z\in Z} p(z) u(z)")

Our preferred action will be:

![a^\*=\\text{argmax}\_a{ \\left\\{u\_\\pi(a)\\right\\} }](https://latex.codecogs.com/png.latex?a%5E%2A%3D%5Ctext%7Bargmax%7D_a%7B%20%5Cleft%5C%7Bu_%5Cpi%28a%29%5Cright%5C%7D%20%7D "a^*=\text{argmax}_a{ \left\{u_\pi(a)\right\} }")

Denote ![\\prec](https://latex.codecogs.com/png.latex?%5Cprec "\prec") a binary preference that is such that ![a \\prec a'](https://latex.codecogs.com/png.latex?a%20%5Cprec%20a%27 "a \prec a'") indicates that action ![a'](https://latex.codecogs.com/png.latex?a%27 "a'") is preferred to action a strictly. ![a \\sim a'](https://latex.codecogs.com/png.latex?a%20%5Csim%20a%27 "a \sim a'") indicates indifference. ![a\\preceq a'](https://latex.codecogs.com/png.latex?a%5Cpreceq%20a%27 "a\preceq a'") indicates preferred or indifferent.

We need two assumptions:

-   completeness: for any two actions, ![a, a' \\in { \\mathcal{A} }](https://latex.codecogs.com/png.latex?a%2C%20a%27%20%5Cin%20%7B%20%5Cmathcal%7BA%7D%20%7D "a, a' \in { \mathcal{A} }"), one and only one of the following holds:
    -   ![a \\prec a'](https://latex.codecogs.com/png.latex?a%20%5Cprec%20a%27 "a \prec a'") or ![a \\succ a'](https://latex.codecogs.com/png.latex?a%20%5Csucc%20a%27 "a \succ a'") or ![a \\sim a'](https://latex.codecogs.com/png.latex?a%20%5Csim%20a%27 "a \sim a'"). "I don't know" is not allowed.
-   Transitivity: for any ![a, a', a'' \\in { \\mathcal{A} }](https://latex.codecogs.com/png.latex?a%2C%20a%27%2C%20a%27%27%20%5Cin%20%7B%20%5Cmathcal%7BA%7D%20%7D "a, a', a'' \in { \mathcal{A} }") , ![a\\preceq a'](https://latex.codecogs.com/png.latex?a%5Cpreceq%20a%27 "a\preceq a'") and ![a' \\preceq a''](https://latex.codecogs.com/png.latex?a%27%20%5Cpreceq%20a%27%27 "a' \preceq a''") implies ![a \\preceq a''](https://latex.codecogs.com/png.latex?a%20%5Cpreceq%20a%27%27 "a \preceq a''").

Notation: ![a, a' \\in { \\mathcal{A} }, \\alpha \\in {\\left\[0,1\\right\]}, \\text{ then } a'' = \\alpha a + (1-\\alpha) a'](https://latex.codecogs.com/png.latex?a%2C%20a%27%20%5Cin%20%7B%20%5Cmathcal%7BA%7D%20%7D%2C%20%5Calpha%20%5Cin%20%7B%5Cleft%5B0%2C1%5Cright%5D%7D%2C%20%5Ctext%7B%20then%20%7D%20a%27%27%20%3D%20%5Calpha%20a%20%2B%20%281-%5Calpha%29%20a%27 "a, a' \in { \mathcal{A} }, \alpha \in {\left[0,1\right]}, \text{ then } a'' = \alpha a + (1-\alpha) a'"), is the action that assigns probability ![\\alpha p(z) + (1-\\alpha)p'(z)](https://latex.codecogs.com/png.latex?%5Calpha%20p%28z%29%20%2B%20%281-%5Calpha%29p%27%28z%29 "\alpha p(z) + (1-\alpha)p'(z)").

The Von-Neumann-Morgenstern theory requires the following conditions:

1.  ![\\prec](https://latex.codecogs.com/png.latex?%5Cprec "\prec") is complete and transitive
2.  independence: ![a, a', a'' \\in { \\mathcal{A} }](https://latex.codecogs.com/png.latex?a%2C%20a%27%2C%20a%27%27%20%5Cin%20%7B%20%5Cmathcal%7BA%7D%20%7D "a, a', a'' \in { \mathcal{A} }") and ![\\alpha \\in {\\left\[0,1\\right\]}](https://latex.codecogs.com/png.latex?%5Calpha%20%5Cin%20%7B%5Cleft%5B0%2C1%5Cright%5D%7D "\alpha \in {\left[0,1\right]}"), ![a \\succ a'  \\Rightarrow (1-\\alpha) a'' + \\alpha a \\succ (1-\\alpha) a'' + \\alpha a'](https://latex.codecogs.com/png.latex?a%20%5Csucc%20a%27%20%20%5CRightarrow%20%281-%5Calpha%29%20a%27%27%20%2B%20%5Calpha%20a%20%5Csucc%20%281-%5Calpha%29%20a%27%27%20%2B%20%5Calpha%20a%27 "a \succ a'  \Rightarrow (1-\alpha) a'' + \alpha a \succ (1-\alpha) a'' + \alpha a'").
3.  Archimedean: ![a, a', a'' \\in { \\mathcal{A} }](https://latex.codecogs.com/png.latex?a%2C%20a%27%2C%20a%27%27%20%5Cin%20%7B%20%5Cmathcal%7BA%7D%20%7D "a, a', a'' \in { \mathcal{A} }"). For ![a\\succ a' \\succ a''](https://latex.codecogs.com/png.latex?a%5Csucc%20a%27%20%5Csucc%20a%27%27 "a\succ a' \succ a''"), there exists ![\\alpha, \\beta \\in(0,1)](https://latex.codecogs.com/png.latex?%5Calpha%2C%20%5Cbeta%20%5Cin%280%2C1%29 "\alpha, \beta \in(0,1)") such that ![\\alpha a + (1-\\alpha) a'' \\succ a' \\succ  \\beta a + (1-\\beta)a''](https://latex.codecogs.com/png.latex?%5Calpha%20a%20%2B%20%281-%5Calpha%29%20a%27%27%20%5Csucc%20a%27%20%5Csucc%20%20%5Cbeta%20a%20%2B%20%281-%5Cbeta%29a%27%27 "\alpha a + (1-\alpha) a'' \succ a' \succ  \beta a + (1-\beta)a''")

See Theorem 3.1 in Parmigiani & Inoue

The result indicates that our preferences for actions can be translated into an ordering of expected utilities.

How do we come up with such a function?

Denote ![{ \\text{&lt;} }z { \\text{&gt;} }](https://latex.codecogs.com/png.latex?%7B%20%5Ctext%7B%3C%7D%20%7Dz%20%7B%20%5Ctext%7B%3E%7D%20%7D "{ \text{<} }z { \text{>} }") the probability distribution that gives probability one to reward ![z](https://latex.codecogs.com/png.latex?z "z").

-   step 1: choose two rewards that are NOT equivalent, say ![z\_1](https://latex.codecogs.com/png.latex?z_1 "z_1") and ![z\_2](https://latex.codecogs.com/png.latex?z_2 "z_2"). Assume ![{ \\tltz\_1{ \\text{&gt;} }} \\prec { \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Cprec%20%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_1{ \text{>} }} \prec { \tltz_2{ \text{>} }}"). ![u(z\_1) = 0, u(z\_2)=1](https://latex.codecogs.com/png.latex?u%28z_1%29%20%3D%200%2C%20u%28z_2%29%3D1 "u(z_1) = 0, u(z_2)=1").
-   step 2: For reward ![z\_3](https://latex.codecogs.com/png.latex?z_3 "z_3") that is such that ![{ \\text{&lt;} }z\_1 { \\text{&gt;} }\\prec { \\text{&lt;} }z\_3 { \\text{&gt;} }\\prec { \\text{&lt;} }z\_2 { \\text{&gt;} }](https://latex.codecogs.com/png.latex?%7B%20%5Ctext%7B%3C%7D%20%7Dz_1%20%7B%20%5Ctext%7B%3E%7D%20%7D%5Cprec%20%7B%20%5Ctext%7B%3C%7D%20%7Dz_3%20%7B%20%5Ctext%7B%3E%7D%20%7D%5Cprec%20%7B%20%5Ctext%7B%3C%7D%20%7Dz_2%20%7B%20%5Ctext%7B%3E%7D%20%7D "{ \text{<} }z_1 { \text{>} }\prec { \text{<} }z_3 { \text{>} }\prec { \text{<} }z_2 { \text{>} }")
    -   Find ![\\alpha \\in (0,1)](https://latex.codecogs.com/png.latex?%5Calpha%20%5Cin%20%280%2C1%29 "\alpha \in (0,1)") such that ![{ \\text{&lt;} }z\_3 { \\text{&gt;} }\\approx \\alpha { \\text{&lt;} }z\_1 { \\text{&gt;} }+ (1-\\alpha) { \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctext%7B%3C%7D%20%7Dz_3%20%7B%20%5Ctext%7B%3E%7D%20%7D%5Capprox%20%5Calpha%20%7B%20%5Ctext%7B%3C%7D%20%7Dz_1%20%7B%20%5Ctext%7B%3E%7D%20%7D%2B%20%281-%5Calpha%29%20%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \text{<} }z_3 { \text{>} }\approx \alpha { \text{<} }z_1 { \text{>} }+ (1-\alpha) { \tltz_2{ \text{>} }}") then ![u(z\_3) = \\alpha u(z\_1) + (1-\\alpha) u(z\_2) = 1 - \\alpha](https://latex.codecogs.com/png.latex?u%28z_3%29%20%3D%20%5Calpha%20u%28z_1%29%20%2B%20%281-%5Calpha%29%20u%28z_2%29%20%3D%201%20-%20%5Calpha "u(z_3) = \alpha u(z_1) + (1-\alpha) u(z_2) = 1 - \alpha").
-   step 3: For a reward ![{ \\tltz\_4{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_4%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_4{ \text{>} }}") such that ![{ \\tltz\_1{ \\text{&gt;} }} \\succ { \\tltz\_4{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Csucc%20%7B%20%5Ctltz_4%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_1{ \text{>} }} \succ { \tltz_4{ \text{>} }}"). Find ![\\alpha](https://latex.codecogs.com/png.latex?%5Calpha "\alpha") such that

    ![{ \\tltz\_1{ \\text{&gt;} }} \\approx \\alpha { \\tltz\_4{ \\text{&gt;} }} + (1-\\alpha) { \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Capprox%20%5Calpha%20%7B%20%5Ctltz_4%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%2B%20%281-%5Calpha%29%20%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_1{ \text{>} }} \approx \alpha { \tltz_4{ \text{>} }} + (1-\alpha) { \tltz_2{ \text{>} }}")

    ![0 = u(z\_1) = \\alpha(z\_4) + (1-\\alpha) \\Rightarrow u(z\_4) = - (1-\\alpha) / \\alpha](https://latex.codecogs.com/png.latex?0%20%3D%20u%28z_1%29%20%3D%20%5Calpha%28z_4%29%20%2B%20%281-%5Calpha%29%20%5CRightarrow%20u%28z_4%29%20%3D%20-%20%281-%5Calpha%29%20%2F%20%5Calpha "0 = u(z_1) = \alpha(z_4) + (1-\alpha) \Rightarrow u(z_4) = - (1-\alpha) / \alpha")

-   step 4: ![{ \\tltz\_2{ \\text{&gt;} }} \\prec { \\tltz\_5{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Cprec%20%7B%20%5Ctltz_5%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_2{ \text{>} }} \prec { \tltz_5{ \text{>} }}") ... ![u(z\_5) = 1 / (1-\\alpha)](https://latex.codecogs.com/png.latex?u%28z_5%29%20%3D%201%20%2F%20%281-%5Calpha%29 "u(z_5) = 1 / (1-\alpha)")
-   step 5: consistency check: Find ![\\alpha](https://latex.codecogs.com/png.latex?%5Calpha "\alpha") such that ![{ \\tltz\_5{ \\text{&gt;} }} = \\alpha{}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_5%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%3D%20%5Calpha%7B%7D "{ \tltz_5{ \text{>} }} = \alpha{}") ...

Example: Saturday afternoon you have the following choices.

-   ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1"): go to a football game
-   ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2"): go to a movie

Your preference is for ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1") but the weather might be bad.

-   ![\\theta\_1](https://latex.codecogs.com/png.latex?%5Ctheta_1 "\theta_1"): bad weather. ![\\pi(\\theta\_1) = .4](https://latex.codecogs.com/png.latex?%5Cpi%28%5Ctheta_1%29%20%3D%20.4 "\pi(\theta_1) = .4").
-   ![\\theta\_2](https://latex.codecogs.com/png.latex?%5Ctheta_2 "\theta_2"): good weather. ![\\pi(\\theta\_2) = .6](https://latex.codecogs.com/png.latex?%5Cpi%28%5Ctheta_2%29%20%3D%20.6 "\pi(\theta_2) = .6").

You have four possible rewards. ![z\_1 = (a\_1, \\theta\_1), z\_2 = (a\_1, \\theta\_2), z\_3 = (a\_2, \\theta\_1), z\_4 = (a\_2, \\theta\_2)](https://latex.codecogs.com/png.latex?z_1%20%3D%20%28a_1%2C%20%5Ctheta_1%29%2C%20z_2%20%3D%20%28a_1%2C%20%5Ctheta_2%29%2C%20z_3%20%3D%20%28a_2%2C%20%5Ctheta_1%29%2C%20z_4%20%3D%20%28a_2%2C%20%5Ctheta_2%29 "z_1 = (a_1, \theta_1), z_2 = (a_1, \theta_2), z_3 = (a_2, \theta_1), z_4 = (a_2, \theta_2)")

You have the following preferences: ![{ \\tltz\_1{ \\text{&gt;} }} \\prec { \\tltz\_4{ \\text{&gt;} }} \\prec { \\tltz\_3{ \\text{&gt;} }} \\prec { \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Cprec%20%7B%20%5Ctltz_4%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Cprec%20%7B%20%5Ctltz_3%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Cprec%20%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_1{ \text{>} }} \prec { \tltz_4{ \text{>} }} \prec { \tltz_3{ \text{>} }} \prec { \tltz_2{ \text{>} }}")

![u(z\_1) = 0, u(z\_2)=1](https://latex.codecogs.com/png.latex?u%28z_1%29%20%3D%200%2C%20u%28z_2%29%3D1 "u(z_1) = 0, u(z_2)=1"). Compare ![{ \\tltz\_4{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_4%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_4{ \text{>} }}") to a mixture of ![{ \\tltz\_1{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_1{ \text{>} }}") and ![{ \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_2{ \text{>} }}"), we get ![\\alpha = .4](https://latex.codecogs.com/png.latex?%5Calpha%20%3D%20.4 "\alpha = .4"), which implies that ![u(z\_4) = 0.6](https://latex.codecogs.com/png.latex?u%28z_4%29%20%3D%200.6 "u(z_4) = 0.6").

Now we set ![{ \\tltz\_3{ \\text{&gt;} }} \\approx 0.3 { \\tltz\_1{ \\text{&gt;} }} + 0.7 { \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_3%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Capprox%200.3%20%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%2B%200.7%20%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_3{ \text{>} }} \approx 0.3 { \tltz_1{ \text{>} }} + 0.7 { \tltz_2{ \text{>} }}"), which implies that ![u(z\_3) = .7](https://latex.codecogs.com/png.latex?u%28z_3%29%20%3D%20.7 "u(z_3) = .7")

We check our assessments by looking at ![{ \\tltz\_3{ \\text{&gt;} }} \\approx \\alpha { \\tltz\_4{ \\text{&gt;} }} + (1-\\alpha) { \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_3%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Capprox%20%5Calpha%20%7B%20%5Ctltz_4%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%2B%20%281-%5Calpha%29%20%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_3{ \text{>} }} \approx \alpha { \tltz_4{ \text{>} }} + (1-\alpha) { \tltz_2{ \text{>} }}"). We get ![\\alpha = .6](https://latex.codecogs.com/png.latex?%5Calpha%20%3D%20.6 "\alpha = .6"), which is a contradiction because ![u(z\_3) = .7 = .6 \\alpha + (1-\\alpha) \\Rightarrow \\alpha = .75](https://latex.codecogs.com/png.latex?u%28z_3%29%20%3D%20.7%20%3D%20.6%20%5Calpha%20%2B%20%281-%5Calpha%29%20%5CRightarrow%20%5Calpha%20%3D%20.75 "u(z_3) = .7 = .6 \alpha + (1-\alpha) \Rightarrow \alpha = .75")

We revise and conclude that ![{ \\tltz\_3{ \\text{&gt;} }} \\approx .25 { \\tltz\_1{ \\text{&gt;} }} + .75{ \\tltz\_2{ \\text{&gt;} }}](https://latex.codecogs.com/png.latex?%7B%20%5Ctltz_3%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%5Capprox%20.25%20%7B%20%5Ctltz_1%7B%20%5Ctext%7B%3E%7D%20%7D%7D%20%2B%20.75%7B%20%5Ctltz_2%7B%20%5Ctext%7B%3E%7D%20%7D%7D "{ \tltz_3{ \text{>} }} \approx .25 { \tltz_1{ \text{>} }} + .75{ \tltz_2{ \text{>} }}") which implies ![u(z\_3)=.75](https://latex.codecogs.com/png.latex?u%28z_3%29%3D.75 "u(z_3)=.75")

-   ![a\_1](https://latex.codecogs.com/png.latex?a_1 "a_1"): ![E(u(z)) = \\pi(\\theta\_1)u(z\_1) + \\pi(\\theta\_2)u(z\_2) = .60](https://latex.codecogs.com/png.latex?E%28u%28z%29%29%20%3D%20%5Cpi%28%5Ctheta_1%29u%28z_1%29%20%2B%20%5Cpi%28%5Ctheta_2%29u%28z_2%29%20%3D%20.60 "E(u(z)) = \pi(\theta_1)u(z_1) + \pi(\theta_2)u(z_2) = .60")
-   ![a\_2](https://latex.codecogs.com/png.latex?a_2 "a_2"): ![E(u(z)) = \\pi(\\theta\_1)u(z\_3) + \\pi(\\theta\_2)u(z\_4) = .66](https://latex.codecogs.com/png.latex?E%28u%28z%29%29%20%3D%20%5Cpi%28%5Ctheta_1%29u%28z_3%29%20%2B%20%5Cpi%28%5Ctheta_2%29u%28z_4%29%20%3D%20.66 "E(u(z)) = \pi(\theta_1)u(z_3) + \pi(\theta_2)u(z_4) = .66")

Therefore, GO TO THE MOVIES!
