/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp27_ueb04;

/**
 *
 * @author Robin
 */
public class Set {

    /**
     * Variable of typ Element
     */
    private Element elements;

    /**
     * Proofs if a set contains elements or not
     *
     * @return true if set contains elements, false if not
     */
    public boolean isEmpty() {
        return elements == null;
    }

    /**
     * Inserts an element to a list so that the element is still in ascending
     * order if it was before
     *
     * @param value the value of the element that should be inserted
     */
    public void insertElement(int value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        } else {
            if (elements.containsValue(value) != true) {
                elements = elements.insertElement(value);
            }
        }

    }

    /**
     * detemines if set contains an element with a given value
     *
     * @param value the to be checked value
     * @return true, if an element exist with the input value
     */
    public boolean existsElement(int value) {
        if (isEmpty()) {
            return false;
        } else {
            return elements.containsValue(value);
        }
    }

    /**
     * Deletes the first element of a list with the committed value
     *
     * @param value the value of the element that should be deleted
     */
    public void deleteElement(int value) {
        if (!isEmpty()) {
            elements = elements.deleteElement(value);
        }
    }

    /**
     * gives back a string with all values of all elements
     *
     * @return a string with all values of all elements
     */
    public String showValues() {
        if (isEmpty()) {
            return "{}";
        } else {
            return "{" + elements.showValues() + "}";
        }
    }

    public Set union(Set otherSet) {
        Set resultSet = new Set();
        if (!this.isEmpty()) {
            for (int i = 0; i < this.elements.size(); i++) {

                resultSet.insertElement(this.elements.getValueAt(i));

            }
        }

        if (!otherSet.isEmpty()) {
            for (int i = 0; i < otherSet.elements.size(); i++) {
                if (resultSet.existsElement(otherSet.elements.getValueAt(i)) == false) {
                    resultSet.insertElement(otherSet.elements.getValueAt(i));
                }
            }
        }

        return resultSet;
    }

    public Set intersection(Set otherSet) {
        Set resultSet = new Set();

        if (!this.isEmpty() && !otherSet.isEmpty()) {

            Set menge1;
            Set menge2;

            if (this.elements.size() > otherSet.elements.size()) {
                menge1 = otherSet;
                menge2 = this;
            } else {
                menge1 = this;
                menge2 = otherSet;
            }

            for (int i = 0; i < menge1.elements.size(); i++) {

                if (menge2.elements.containsValue(menge1.elements.getValueAt(i))) {
                    resultSet.insertElement(menge1.elements.getValueAt(i));
                }
            }
        }

        return resultSet;
    }

    public Set diff(Set otherSet) {
        Set resultSet = new Set();

        if (!this.isEmpty() && !otherSet.isEmpty()) {

            for (int i = 0; i < this.elements.size(); i++) {

                if (!otherSet.elements.containsValue(this.elements.getValueAt(i))) {
                    resultSet.insertElement(this.elements.getValueAt(i));
                }
            }
        } else if (!this.isEmpty() && otherSet.isEmpty()) {
            resultSet = this;
        }

        return resultSet;
    }

    public boolean isSame(Set otherSet) {

        if (!this.isEmpty() && !otherSet.isEmpty()) {

            Set menge1;
            Set menge2;
            int zaehler;

            if (this.elements.size() > otherSet.elements.size()) {
                menge1 = otherSet;
                menge2 = this;
            } else {
                menge1 = this;
                menge2 = otherSet;
            }

            for (zaehler = 0; (this.elements.getValueAt(zaehler) != otherSet.elements.getValueAt(zaehler))
                    || zaehler < menge1.elements.size(); zaehler++) {

            }
            return zaehler == menge1.elements.size();
        } else {
            return !((!this.isEmpty() && otherSet.isEmpty()) || (this.isEmpty() && !otherSet.isEmpty()));
        }
    }

    public boolean isProperSubSet(Set otherSet) {

        return this.isSame(this.intersection(otherSet)) && !otherSet.isSame(this.intersection(otherSet));
    }
}
