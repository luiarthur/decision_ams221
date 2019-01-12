f = function(n, x) {
  p_snx = dbinom(x, n, .9) * .2 + dbinom(x, n, .4) * .8
  p_nx = dbinom(x, n, .9) * .2 / p_snx

  a = (-50 * n + 700) * p_nx + (-50 * n + 800) * (1-p_nx)
  b = (-50 * n + 0) * p_nx + (-50 * n + 1000) * (1-p_nx)
  cat('n: ', n, ', x: ', x, ', a: ', a, ', b: ', b, ', p_snx: ', p_snx, '\n', sep='')
  max(a, b) * p_snx
}


N = 10
m = rep(NA, N)
for (n in 1:N) {
  m[n] = sum(sapply(0:n, function(x) f(n, x)))
}

plot(m, type='o', ylab='Profit', xlab='number of alarm devices (n)')
