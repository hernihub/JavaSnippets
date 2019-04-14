public final class SafeThreadSingleton {
	
	private SafeThreadSingleton() {
		
	}
	
	public final static SafeThreadSingleton getInstance() {
		return ImplicitInstanceHolder.getInstance();
	}
	
	private static final class ImplicitInstanceHolder {
		private static SafeThreadSingleton uniqueInstance = null;
		
		static final SafeThreadSingleton getInstance() {
			if (uniqueInstance == null) {
				uniqueInstance = new SafeThreadSingleton();
			}
			return uniqueInstance;
		}
	}
}
