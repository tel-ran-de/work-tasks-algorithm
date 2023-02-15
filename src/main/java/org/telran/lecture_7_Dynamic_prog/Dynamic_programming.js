/** ФИБОНАЧЧИ: МЕМОИЗАЦИЯ и ТАБУЛЯЦИЯ */

function init() {
    let num = 5;
    let arr = new Array(num + 1);
    for(let i = 2; i <= num; i++) {
        arr[i] = -1;
    }

    console.log(fibonacciRecursion(num));
    console.log(fibonacciDpMemoization(num, arr));
    console.log(fibonacciDpTabulation(num));
}

function fibonacciRecursion(n) {
    if (n < 2) {
        return 1;
    }
    return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
}

function fibonacciDpMemoization(n, arr) {
    if (n < 2) {
        return 1;
    }
    if (arr[n] !== -1) {
        return arr[n];
    }
    arr[n] = fibonacciDpMemoization(n - 1, arr) + fibonacciDpMemoization(n - 2, arr);
    return arr[n];
}

function fibonacciDpTabulation(n) {
    let arr = new Array(n + 1);
    arr[0] = 1;
    arr[1] = 1;
    let res = 0;
    for (let i = 2; i <= n; i++) {
        arr[i] = arr[i - 2] + arr[i - 1];
        if (i === n) {
            res = arr[i];
        }
    }
    return res;
}
init();

