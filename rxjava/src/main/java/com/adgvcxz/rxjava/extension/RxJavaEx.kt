package com.adgvcxz.rxjava.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

/**
 * zhaowei
 * Created by zhaowei on 2017/7/13.
 */

fun Disposable.addTo(disposables: CompositeDisposable) {
    disposables.add(this)
}

fun List<Disposable>.addTo(disposables: CompositeDisposable) {
    forEach { it.addTo(disposables) }
}

fun <T> Observable<T>.httpScheduler(): Observable<T> {
    return this.compose { it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
}

fun <T> Observable<T>.takeFirst(t: T): Observable<T> {
    return filter { t == it }.take(1)
}

fun <T> Observable<T>.takeFirst(predicate: Predicate<in T>): Observable<T> {
    return filter(predicate).take(1)
}

inline fun <T, R> Observable<T>.singleToList(crossinline transform: (T) -> R): Observable<List<R>> {
    return map { transform(it) }.toList().toObservable()
}

inline fun <T, R> Observable<List<T>>.formatList(crossinline transform: (T) -> R): Observable<List<R>> {
    return map { it.map { transform(it) } }
}