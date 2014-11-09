public interface ListTester {
	
	/** @return the number of milliseconds it takes to add a million elements to the IList
	 * @param l the IList to add 1 million elements to
	 */
	public long addAMillion(IList l);

	/** @return the number of milliseconds it takes to add a billion elements to the IList
	 * @param l the IList to add 1 billion elements to
	 */
	public long addABillion(IList l);

	/** @return the number of milliseconds it takes to add n elements to the IList
	 * @param l the IList to add N elements to
	 * @param n the number of elements desired
	 */
	public long addN(IList l, long n);
	
	/** @return the number of milliseconds it takes to count the number of chars and words in a given file
	 * @param fileName the name of the file
	 * @param charList the IList to add characters to
	 * @param wordList the IList to add words to
	 */
	public long textFileInfo(String fileName, IList charList, IList wordList);
	
	/** @return the number of milliseconds it takes to reverse the order of the elements in this list
	 * @param l the IList being reversed
	 */
	public long reverseOrder(IList l);

}
