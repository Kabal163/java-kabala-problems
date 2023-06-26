package com.github.kabal163.java.problems.bank.solution;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<Key, Cell> cells;

    public Bank() {
        this.cells = new HashMap<>();
    }

    /**
     * Создает новую банковскую ячейку и возвращает ключ к этой ячейке.
     * Если по заданным клиентским данным уже существует ячейка, тогда
     * новая не будет создана.
     *
     * @return ключ к ячейке
     */
    public Key newCell(String fingerprint) {
        Key key = new Key(fingerprint);
        cells.putIfAbsent(key, new Cell());

        return key;
    }

    /**
     * Возвращает банковскую ячейку, ассоциированную с заданным ключом.
     *
     * @param key ключ к ячейке
     * @return банковскую ячейку
     * @throws UnknownKeyException если ключ не ассоциирован ни с одной ячейкой
     */
    public Cell cell(Key key) {
        Cell cell = cells.get(key);

        if (cell == null) {
            throw new UnknownKeyException(
                "Неизвестный ключ %s. Данный ключ не подходит ни к одной ячейке".formatted(key)
            );
        }

        return cell;
    }

    /**
     * Кладет банкноты в ячейку, ассоциированную с указанным ключом.
     *
     * @param key       ключ к ячейке
     * @param banknotes банкноты, которые нужно положить в ячейку
     * @throws UnknownKeyException если ключ не ассоциирован ни с одной ячейкой
     */
    public void putBanknotes(Key key, Collection<Banknote> banknotes) {
        Cell cell = cell(key);
        cells.put(key, cell.putBanknotes(banknotes));
    }

    /**
     * Кладет марки в ячейку, ассоциированную с указанным ключом
     *
     * @param key   ключ к ячейке
     * @param marks марки, которые нужно положить в ячейку
     * @throws UnknownKeyException если ключ не ассоциирован ни с одной ячейкой
     */
    public void putMarks(Key key, Collection<Mark> marks) {
        Cell cell = cell(key);
        cells.put(key, cell.putMarks(marks));
    }
}
