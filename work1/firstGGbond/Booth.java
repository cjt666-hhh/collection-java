
public class Booth {
	private long id;
	private String name;
	private int total;
	private boolean isClosed;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	public Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
		this.name = name;
        this.total = total;
        this.isClosed = isClosed;
	}
	 public String toString(){
			return  "ID: " + id + "\n" +
	                "NAME: " + name + "\n" +
	                "Number of watermelon " + total + "\n"+
	                "Closed ? "+ isClosed +"\n";
	 }
	 public static void purchase(Booth marchant, int shop ) {
		 if(shop>marchant.getTotal()) {
			 System.out.println("��Ӧ���㣬�鷳����һ��");
		 }
		 if(shop<marchant.getTotal()) {
			 marchant.setTotal(marchant.getTotal()-shop);
			 System.out.println("����ɹ�����ӭ�´ι���");
		 }
	 }
	 public  void restock(int num) {
		 if(num>200) {
			 System.out.println("����������");
		 }
		 else if(num<0) {
			 System.out.println("��Ч����");
		 }
		 else {
			 System.out.println("�����ɹ�");
			 this.total = total + num;
		 }
	 }
	 public static void closeBooths(Booth[] booths){
		 for(int i =0;i<booths.length;i++) {
			 if(booths[i].isClosed()) {
				 System.out.println(booths[i].toString());
			 }
			 else if(!booths[i].isClosed()) {
				 booths[i].setClosed(true);
			 }
		 }
	 }
}
