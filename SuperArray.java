public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray () {
    data = new String[10];
  }

  public void clear(){
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public boolean add(String s) {
    if (data.length > size()) {
      data[size] = s;
      size++ ;
    }
    else {
      //resize();
      add(s);
    }
    return true;
  }

  public String toString() {
    String rtn = "[";
    if (size() == 0){
      rtn += "]";
    }
    for (int i = 0; i < size(); i++) {
      if (i < size() - 1) {
        rtn += data[i] + ", ";
      }
      else {
        rtn += data[i] + "]";
      }
    }
    return rtn;
  }

}
