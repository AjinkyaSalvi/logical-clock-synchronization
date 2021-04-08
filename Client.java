import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
	public static void main(String args[]) throws Exception
	{
		// Request connection to server
		Socket s = new Socket("127.0.0.1", 1404);

		// Create text output and input streams
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		Scanner t = new Scanner(System.in);

		String smsgin,cn;
		int c=0,n1=0,n2=0;
		int e[]=new int[3],e1[]=new int[3], e2[]=new int[3], e3[]=new int[3];

		//  Receive text message
		smsgin = dis.readUTF();
		System.out.println(smsgin);

		// Receive client number
		cn = dis.readUTF();
		while(true)
		{
			System.out.print("\n\nWant to perform addition?\n(Enter '1' for 'yes' or '0' for 'no'.)");
			c=t.nextInt();
			if(c==0)
			{
				dos.writeUTF("0");
			}
			else
			{
				System.out.print("\n\nEnter two numbers:\n");
				n1=t.nextInt();
				n2=t.nextInt();
				n1=n1+n2;
				System.out.print("\nSum: "+n1);
				dos.writeUTF("1");
				if(cn.equals("1"))
					e[0]++;
				if(cn.equals("2"))
					e[1]++;
				if(cn.equals("3"))
					e[2]++;
				dos.writeUTF(""+e[0]);
				dos.writeUTF(""+e[1]);
				dos.writeUTF(""+e[2]);
				if(cn.equals("1"))
					e[0]--;
				if(cn.equals("2"))
					e[1]--;
				if(cn.equals("3"))
					e[2]--;
			}
			{
				smsgin=dis.readUTF();
				if(smsgin.equals("cn1"))
				{
					e1[0]=Integer.parseInt(dis.readUTF());
					e1[1]=Integer.parseInt(dis.readUTF());
					e1[2]=Integer.parseInt(dis.readUTF());

					if(e[0]<e1[0])
					{
						e[0]=e1[0];
						System.out.print("\n\nEvent: 1."+e[0]);
					}
					if(e[1]<e1[1])
					{
						e[1]=e1[1];
						System.out.print("\n\nEvent: 1."+e[1]);
					}
					if(e[2]<e1[2])
					{
						e[2]=e1[2];
						System.out.print("\n\nEvent: 1."+e[2]);
					}
				}
				if(smsgin.equals("cn2"))
				{
					e2[0]=Integer.parseInt(dis.readUTF());
					e2[1]=Integer.parseInt(dis.readUTF());
					e2[2]=Integer.parseInt(dis.readUTF());

					if(e[0]<e2[0])
					{
						e[0]=e2[0];
						System.out.print("\n\nEvent: 2."+e[0]);
					}
					if(e[1]<e2[1])
					{
						e[1]=e2[1];
						System.out.print("\n\nEvent: 2."+e[1]);
					}
					if(e[2]<e2[2])
					{
						e[2]=e2[2];
						System.out.print("\n\nEvent: 2."+e[2]);
					}
				}
				if(smsgin.equals("cn3"))
				{

					e3[0]=Integer.parseInt(dis.readUTF());
					e3[1]=Integer.parseInt(dis.readUTF());
					e3[2]=Integer.parseInt(dis.readUTF());

					if(e[0]<e3[0])
					{
						e[0]=e3[0];
						System.out.print("\n\nEvent: 3."+e[0]);
					}
					if(e[1]<e3[1])
					{
						e[1]=e3[1];
						System.out.print("\n\nEvent: 3."+e[1]);
					}
					if(e[2]<e3[2])
					{
						e[2]=e3[2];
						System.out.print("\n\nEvent: 3."+e[2]);
					}
				}
				if(smsgin.equals("cn1 cn2"))
				{
					e1[0]=Integer.parseInt(dis.readUTF());
					e1[1]=Integer.parseInt(dis.readUTF());
					e1[2]=Integer.parseInt(dis.readUTF());
					e2[0]=Integer.parseInt(dis.readUTF());
					e2[1]=Integer.parseInt(dis.readUTF());
					e2[2]=Integer.parseInt(dis.readUTF());

					if(e[0]<e1[0])
					{
						e[0]=e1[0];
						System.out.print("\n\nEvent: 1."+e[0]);
					}
					if(e[1]<e1[1])
					{
						e[1]=e1[1];
						System.out.print("\n\nEvent: 1."+e[1]);
					}
					if(e[2]<e1[2])
					{
						e[2]=e1[2];
						System.out.print("\n\nEvent: 1."+e[2]);
					}
					if(e[0]<e2[0])
					{
						e[0]=e2[0];
						System.out.print("\n\nEvent: 2."+e[0]);
					}
					if(e[1]<e2[1])
					{
						e[1]=e2[1];
						System.out.print("\n\nEvent: 2."+e[1]);
					}
					if(e[2]<e2[2])
					{
						e[2]=e2[2];
						System.out.print("\n\nEvent: 2."+e[2]);
					}
				}
				if(smsgin.equals("cn1 cn3"))
				{
					e1[0]=Integer.parseInt(dis.readUTF());
					e1[1]=Integer.parseInt(dis.readUTF());
					e1[2]=Integer.parseInt(dis.readUTF());
					e3[0]=Integer.parseInt(dis.readUTF());
					e3[1]=Integer.parseInt(dis.readUTF());
					e3[2]=Integer.parseInt(dis.readUTF());

					if(e[0]<e1[0])
					{
						e[0]=e1[0];
						System.out.print("\n\nEvent: 1."+e[0]);
					}
					if(e[1]<e1[1])
					{
						e[1]=e1[1];
						System.out.print("\n\nEvent: 1."+e[1]);
					}
					if(e[2]<e1[2])
					{
						e[2]=e1[2];
						System.out.print("\n\nEvent: 1."+e[2]);
					}
					if(e[0]<e3[0])
					{
						e[0]=e3[0];
						System.out.print("\n\nEvent: 3."+e[0]);
					}
					if(e[1]<e3[1])
					{
						e[1]=e3[1];
						System.out.print("\n\nEvent: 3."+e[1]);
					}
					if(e[2]<e3[2])
					{
						e[2]=e3[2];
						System.out.print("\n\nEvent: 3."+e[2]);
					}
				}
				if(smsgin.equals("cn2 cn3"))
				{
					e2[0]=Integer.parseInt(dis.readUTF());
					e2[1]=Integer.parseInt(dis.readUTF());
					e2[2]=Integer.parseInt(dis.readUTF());
					e3[0]=Integer.parseInt(dis.readUTF());
					e3[1]=Integer.parseInt(dis.readUTF());
					e3[2]=Integer.parseInt(dis.readUTF());

					if(e[0]<e2[0])
					{
						e[0]=e2[0];
						System.out.print("\n\nEvent: 2."+e[0]);
					}
					if(e[1]<e2[1])
					{
						e[1]=e2[1];
						System.out.print("\n\nEvent: 2."+e[1]);
					}
					if(e[2]<e2[2])
					{
						e[2]=e2[2];
						System.out.print("\n\nEvent: 2."+e[2]);
					}
					if(e[0]<e3[0])
					{
						e[0]=e3[0];
						System.out.print("\n\nEvent: 3."+e[0]);
					}
					if(e[1]<e3[1])
					{
						e[1]=e3[1];
						System.out.print("\n\nEvent: 3."+e[1]);
					}
					if(e[2]<e3[2])
					{
						e[2]=e3[2];
						System.out.print("\n\nEvent: 3."+e[2]);
					}
				}
				if(smsgin.equals("cn1 cn2 cn3"))
				{
					e1[0]=Integer.parseInt(dis.readUTF());
					e1[1]=Integer.parseInt(dis.readUTF());
					e1[2]=Integer.parseInt(dis.readUTF());
					e2[0]=Integer.parseInt(dis.readUTF());
					e2[1]=Integer.parseInt(dis.readUTF());
					e2[2]=Integer.parseInt(dis.readUTF());
					e3[0]=Integer.parseInt(dis.readUTF());
					e3[1]=Integer.parseInt(dis.readUTF());
					e3[2]=Integer.parseInt(dis.readUTF());


					if(e[0]<e1[0])
					{
						e[0]=e1[0];
						System.out.print("\n\nEvent: 1."+e[0]);
					}
					if(e[1]<e1[1])
					{
						e[1]=e1[1];
						System.out.print("\n\nEvent: 1."+e[1]);
					}
					if(e[2]<e1[2])
					{
						e[2]=e1[2];
						System.out.print("\n\nEvent: 1."+e[2]);
					}
					if(e[0]<e2[0])
					{
						e[0]=e2[0];
						System.out.print("\n\nEvent: 2."+e[0]);
					}
					if(e[1]<e2[1])
					{
						e[1]=e2[1];
						System.out.print("\n\nEvent: 2."+e[1]);
					}
					if(e[2]<e2[2])
					{
						e[2]=e2[2];
						System.out.print("\n\nEvent: 2."+e[2]);
					}
					if(e[0]<e3[0])
					{
						e[0]=e3[0];
						System.out.print("\n\nEvent: 3."+e[0]);
					}
					if(e[1]<e3[1])
					{
						e[1]=e3[1];
						System.out.print("\n\nEvent: 3."+e[1]);
					}
					if(e[2]<e3[2])
					{
						e[2]=e3[2];
						System.out.print("\n\nEvent: 3."+e[2]);
					}
				}
			}
		}
	}
}
