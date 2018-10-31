public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray () {
    data = new String[10];
  }

  public SuperArray(int startingCapacity) {
    if(startingCapacity < 0){
      throw new IllegalArgumentException();
    }
    data = new String[startingCapacity];
    this.clear();
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
    for (int i = 0; i < size(); i++) {
      if (i < size() - 1) {
        rtn += data[i] + ", ";
      }
      else {
        rtn += data[i];
      }
    }
    return rtn + "]";
  }

  public String toStringDebug() {
    String rtn = "[";
    for (int i = 0; i < data.length; i++) {
      if (i < data.length - 1) {
        rtn += data[i] + ", ";
      }
      else {
        rtn += data[i];
      }
    }
    return rtn + "]";
  }

  public String get(int idx){
    if (idx < 0 || idx >= size()) {
      throw new IndexOutOfBoundsException();
    }
    return data[idx];
  }

  public String set(int idx, String str){
    if (idx < 0 || idx >= size()) {
      throw new IndexOutOfBoundsException();
    }
    String previous = data[idx];
    data[idx] = str;
    return previous;
  }

  private void resize() {
    String newArray[] = new String[2*data.length + 1];
    for (int x = 0; x < size(); x++) {
      newArray[x] = data[x];
    }
    data = newArray;
  }

  public boolean contains(String target) {
    for (int i = 0; i < size(); i++) {
      if(target.equals(data[i])) {
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target) {
    for (int i = 0; i < size(); i++) {
      if(target.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target) {
    int l = -1;
    for (int i = 0; i < size(); i++) {
      if(target.equals(data[i])) {
        l = i;
      }
    }
    return l;
  }

  public void add(int idx, String str) {
    if (idx < 0 || idx > size()) {
      throw new IndexOutOfBoundsException();
    }
    if (size == data.length){
      resize();
    }
    for (int x = size; x >= idx; x--) {
      data[x] = data[x - 1];
    }
    size++;
    data[idx] = str;
  }

  public String remove(int idx) {
    if (idx < 0 || idx >= size()) {
      throw new IndexOutOfBoundsException();
    }
    String oldidx = data[idx];
    for (int i = idx; i <= size(); i++) {
      if (i == size()) {
      data[i] = null;
      }
      else {
        data[i] = data[i+1];
      }
    }
    size--;
    return oldidx;
  }

  public boolean remove(String str) {
    int idx = indexOf(str);
    if (idx == -1){
      return false;
    }
    remove(idx);
    return true;
  }
}
