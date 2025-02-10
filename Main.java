import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) {
		int BEGIN = 10000;
		int N = 479;
		
		int p = N/10;
		int pp = 0;
		
		for(int i=1; i<N; i++){
			if(validate(BEGIN+i))
				System.out.println("i="+(BEGIN+i)+" is true.");
			if(i%p==0)
				System.out.println(++pp+"0% done.");
		}
				
		System.out.println("Validation from "+BEGIN+" stopped at "+(BEGIN+N)+".");
    }
	
	private static boolean validate(int t) {
		return isPSN(
			BigInteger.valueOf(3L)
			.pow(t)
			.subtract(BigInteger.ONE)
			.divide(BigInteger.valueOf(2L))
			.toString()
		);
	}
	
	private static boolean isPSN(String s) {
		BigInteger x = new BigInteger(s);
		BigInteger q = getSqrt(s);
		if(q.multiply(q).compareTo(x)==0) return true;
		else return false;
	}
	
	private static BigInteger getSqrt(String s) {

		BigInteger remain=BigInteger.ZERO;
		BigInteger odd=BigInteger.ZERO;
		BigInteger ans=BigInteger.ZERO;
        int group=0,k=0;
        if(s.length()%2==1)
        {
			group=s.charAt(0)-'0';
			k=-1;
        }
        else
        {
			group=(s.charAt(0)-'0')*10+s.charAt(1)-'0';
			k=0;
        }
		for(int j=0;j<(s.length()+1)/2;j++)
        {
			if(j!=0)
                group=(s.charAt(j*2+k)-'0')*10+s.charAt(j*2+k+1)-'0';
			odd=BigInteger.valueOf(20).multiply(ans).add(BigInteger.ONE);
			remain=BigInteger.valueOf(100).multiply(remain).add(BigInteger.valueOf(group));
			int count=0;
			while(remain.compareTo(odd)>=0)
			{
				count++;
				remain=remain.subtract(odd);
				odd=odd.add(BigInteger.valueOf(2));
			}
			ans=ans.multiply(BigInteger.TEN).add(BigInteger.valueOf(count));
        }
        return ans;    
	}
	
    
}
