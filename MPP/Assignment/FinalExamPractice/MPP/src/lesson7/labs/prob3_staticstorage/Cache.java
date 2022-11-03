package lesson7.labs.prob3_staticstorage;

public interface Cache {
	public default long timeout() {
		//seconds
		return 1;
	}
}
