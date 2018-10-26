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
      resize();
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

  public String toStringDebug() {
    String rtn = "[";
    for (int i = 0; i < data.length; i++) {
      if (i < data.length - 1) {
        rtn += data[i] + ", ";
      }
      else {
        rtn += data[i] + "]";
      }
    }
    return rtn;
  }

  public String get(int idx){
    if (idx < 0 || idx >= size()) {
      System.err.println("Error: idx out of range");
      return null;
    }
    else {
      return data[idx];
    }
  }

  public String set(int idx, String str){
    String previous = "";
    if (idx < 0 || idx >= size()) {
      System.err.print("Error: idx out of range");
      return null;
    }
    else {
      previous = data[idx];
      data[idx] = str;
    }
    return previous;
  }

  private void resize() {
    String newArray[] = new String[2*data.length + 1];
    for (int x = 0; x < size(); x++){
      newArray[x] = data[x];
    }
    data = newArray;
  }

  

}
