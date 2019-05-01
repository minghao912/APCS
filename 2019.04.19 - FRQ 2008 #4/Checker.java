public interface Checker {
    /**
     * @param text a string to consider for acceptance
     * @return true if this <code>Checker</code> accepts <code>text</code>; <code>false</code> otherwise
     */
    boolean accept(String text);
}