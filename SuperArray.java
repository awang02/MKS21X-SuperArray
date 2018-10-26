public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray () {
    String[] data = new String[10];
  }

  public static void clear() {
    String[] data = {};
  }

  public int size() {
    return data.length;
  }

  public boolean isEmpty() {
    if (this.size == 0) {
      return true;
    }
    return false;
  }
}
