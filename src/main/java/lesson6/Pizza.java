package lesson6;

class Pizza {
  String name;
  Integer size;

  public Pizza(String n, Integer s) {
    this.name = n;
    this.size = s;
  }

  @Override
  public boolean equals(Object given) {
    if (given == null) return false;
    if (this == given) return true; // p1.equals(p1)
    if (!(given instanceof Pizza)) return false; // p1.equals(Apple)
    Pizza that = (Pizza) given;

    return this.size.equals(that.size) // Integer.equals
      && this.name.equals(that.name); // String.equals
  }

  public void printMe() {
    System.out.printf(
      "Pizza name %s of size %d\n",
      name, size);
  }
}