fun compose(g: (Int) -> Int, h: (Int) -> Int): (Int) -> Int {
    return { g(h(it)) }
}