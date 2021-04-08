import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
	Socket s1, s2, s3;

	serverthread2(Socket InSocket1, Socket InSocket2, Socket InSocket3)
	{
		s1 = InSocket1;
		s2 = InSocket2;
		s3 = InSocket3;
	}

	public void run()
	{
		try
		{
			// Create text output and input streams
			DataInputStream dis1 = new DataInputStream(s1.getInputStream());
			DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());
			DataInputStream dis2 = new DataInputStream(s2.getInputStream());
			DataOutputStream dos2 = new DataOutputStream(s2.getOutputStream());
			DataInputStream dis3 = new DataInputStream(s3.getInputStream());
			DataOutputStream dos3 = new DataOutputStream(s3.getOutputStream());

			String cmsgin1, cmsgin2, cmsgin3;
			int e1[]=new int[3],e2[]=new int[3],e3[]=new int[3];

			//	Send Server Thread connection message
			dos1.writeUTF("\n\nConnection established.\nWelcome Client 1");
			dos1.flush();
			dos2.writeUTF("\n\nConnection established.\nWelcome Client 2");
			dos2.flush();
			dos3.writeUTF("\n\nConnection established.\nWelcome Client 3");
			dos3.flush();

			// Send Client number
			dos1.writeUTF("1");
			dos1.flush();
			dos2.writeUTF("2");
			dos2.flush();
			dos3.writeUTF("3");
			dos3.flush();

			while(true)
			{
				//	Check message
				cmsgin1 = dis1.readUTF();
				cmsgin2 = dis2.readUTF();cmsgin3 = dis3.readUTF();

				if(cmsgin1.equals("1") && cmsgin2.equals("0") && cmsgin3.equals("0"))
				{
					e1[0]=Integer.parseInt(dis1.readUTF());
					e1[1]=Integer.parseInt(dis1.readUTF());
					e1[2]=Integer.parseInt(dis1.readUTF());

					dos1.writeUTF("cn1");
					dos2.writeUTF("cn1");
					dos3.writeUTF("cn1");

					dos1.writeUTF(""+e1[0]);
					dos1.writeUTF(""+e1[1]);
					dos1.writeUTF(""+e1[2]);
					dos2.writeUTF(""+e1[0]);
					dos2.writeUTF(""+e1[1]);
					dos2.writeUTF(""+e1[2]);
					dos3.writeUTF(""+e1[0]);
					dos3.writeUTF(""+e1[1]);
					dos3.writeUTF(""+e1[2]);
				}

				if(cmsgin1.equals("0") && cmsgin2.equals("1") && cmsgin3.equals("0"))
				{
					e2[0]=Integer.parseInt(dis2.readUTF());
					e2[1]=Integer.parseInt(dis2.readUTF());
					e2[2]=Integer.parseInt(dis2.readUTF());

					dos1.writeUTF("cn2");
					dos2.writeUTF("cn2");
					dos3.writeUTF("cn2");

					dos1.writeUTF(""+e2[0]);
					dos1.writeUTF(""+e2[1]);
					dos1.writeUTF(""+e2[2]);
					dos2.writeUTF(""+e2[0]);
					dos2.writeUTF(""+e2[1]);
					dos2.writeUTF(""+e2[2]);
					dos3.writeUTF(""+e2[0]);
					dos3.writeUTF(""+e2[1]);
					dos3.writeUTF(""+e2[2]);
				}

				if(cmsgin1.equals("0") && cmsgin2.equals("0") && cmsgin3.equals("1"))
				{
					e3[0]=Integer.parseInt(dis3.readUTF());
					e3[1]=Integer.parseInt(dis3.readUTF());
					e3[2]=Integer.parseInt(dis3.readUTF());

					dos1.writeUTF("cn3");
					dos2.writeUTF("cn3");
					dos3.writeUTF("cn3");

					dos1.writeUTF(""+e3[0]);
					dos1.writeUTF(""+e3[1]);
					dos1.writeUTF(""+e3[2]);
					dos2.writeUTF(""+e3[0]);
					dos2.writeUTF(""+e3[1]);
					dos2.writeUTF(""+e3[2]);
					dos3.writeUTF(""+e3[0]);
					dos3.writeUTF(""+e3[1]);
					dos3.writeUTF(""+e3[2]);
				}

				if(cmsgin1.equals("1") && cmsgin2.equals("1") && cmsgin3.equals("0"))
				{
					e1[0]=Integer.parseInt(dis1.readUTF());
					e1[1]=Integer.parseInt(dis1.readUTF());
					e1[2]=Integer.parseInt(dis1.readUTF());

					e2[0]=Integer.parseInt(dis2.readUTF());
					e2[1]=Integer.parseInt(dis2.readUTF());
					e2[2]=Integer.parseInt(dis2.readUTF());

					dos1.writeUTF("cn1 cn2");
					dos2.writeUTF("cn1 cn2");
					dos3.writeUTF("cn1 cn2");

					dos1.writeUTF(""+e1[0]);
					dos1.writeUTF(""+e1[1]);
					dos1.writeUTF(""+e1[2]);
					dos2.writeUTF(""+e1[0]);
					dos2.writeUTF(""+e1[1]);
					dos2.writeUTF(""+e1[2]);
					dos3.writeUTF(""+e1[0]);
					dos3.writeUTF(""+e1[1]);
					dos3.writeUTF(""+e1[2]);
					dos1.writeUTF(""+e2[0]);
					dos1.writeUTF(""+e2[1]);
					dos1.writeUTF(""+e2[2]);
					dos2.writeUTF(""+e2[0]);
					dos2.writeUTF(""+e2[1]);
					dos2.writeUTF(""+e2[2]);
					dos3.writeUTF(""+e2[0]);
					dos3.writeUTF(""+e2[1]);
					dos3.writeUTF(""+e2[2]);
				}

				if(cmsgin1.equals("1") && cmsgin2.equals("0") && cmsgin3.equals("1"))
				{
					e1[0]=Integer.parseInt(dis1.readUTF());
					e1[1]=Integer.parseInt(dis1.readUTF());
					e1[2]=Integer.parseInt(dis1.readUTF());

					e3[0]=Integer.parseInt(dis3.readUTF());
					e3[1]=Integer.parseInt(dis3.readUTF());
					e3[2]=Integer.parseInt(dis3.readUTF());

					dos1.writeUTF("cn1 cn3");
					dos2.writeUTF("cn1 cn3");
					dos3.writeUTF("cn1 cn3");

					dos1.writeUTF(""+e1[0]);
					dos1.writeUTF(""+e1[1]);
					dos1.writeUTF(""+e1[2]);
					dos2.writeUTF(""+e1[0]);
					dos2.writeUTF(""+e1[1]);
					dos2.writeUTF(""+e1[2]);
					dos3.writeUTF(""+e1[0]);
					dos3.writeUTF(""+e1[1]);
					dos3.writeUTF(""+e1[2]);
					dos1.writeUTF(""+e3[0]);
					dos1.writeUTF(""+e3[1]);
					dos1.writeUTF(""+e3[2]);
					dos2.writeUTF(""+e3[0]);
					dos2.writeUTF(""+e3[1]);
					dos2.writeUTF(""+e3[2]);
					dos3.writeUTF(""+e3[0]);
					dos3.writeUTF(""+e3[1]);
					dos3.writeUTF(""+e3[2]);
				}

				if(cmsgin1.equals("0") && cmsgin2.equals("1") && cmsgin3.equals("1"))
				{
					e2[0]=Integer.parseInt(dis2.readUTF());
					e2[1]=Integer.parseInt(dis2.readUTF());
					e2[2]=Integer.parseInt(dis2.readUTF());

					e3[0]=Integer.parseInt(dis3.readUTF());
					e3[1]=Integer.parseInt(dis3.readUTF());
					e3[2]=Integer.parseInt(dis3.readUTF());

					dos1.writeUTF("cn2 cn3");
					dos2.writeUTF("cn2 cn3");
					dos3.writeUTF("cn2 cn3");

					dos1.writeUTF(""+e2[0]);
					dos1.writeUTF(""+e2[1]);
					dos1.writeUTF(""+e2[2]);
					dos2.writeUTF(""+e2[0]);
					dos2.writeUTF(""+e2[1]);
					dos2.writeUTF(""+e2[2]);
					dos3.writeUTF(""+e2[0]);
					dos3.writeUTF(""+e2[1]);
					dos3.writeUTF(""+e2[2]);
					dos1.writeUTF(""+e3[0]);
					dos1.writeUTF(""+e3[1]);
					dos1.writeUTF(""+e3[2]);
					dos2.writeUTF(""+e3[0]);
					dos2.writeUTF(""+e3[1]);
					dos2.writeUTF(""+e3[2]);
					dos3.writeUTF(""+e3[0]);
					dos3.writeUTF(""+e3[1]);
					dos3.writeUTF(""+e3[2]);
				}

				if(cmsgin1.equals("1") && cmsgin2.equals("1") && cmsgin3.equals("1"))
				{
					e1[0]=Integer.parseInt(dis1.readUTF());
					e1[1]=Integer.parseInt(dis1.readUTF());
					e1[2]=Integer.parseInt(dis1.readUTF());

					e2[0]=Integer.parseInt(dis2.readUTF());
					e2[1]=Integer.parseInt(dis2.readUTF());
					e2[2]=Integer.parseInt(dis2.readUTF());

					e3[0]=Integer.parseInt(dis3.readUTF());
					e3[1]=Integer.parseInt(dis3.readUTF());
					e3[2]=Integer.parseInt(dis3.readUTF());

					dos1.writeUTF("cn1 cn2 cn3");
					dos2.writeUTF("cn1 cn2 cn3");
					dos3.writeUTF("cn1 cn2 cn3");

					dos1.writeUTF(""+e1[0]);
					dos1.writeUTF(""+e1[1]);
					dos1.writeUTF(""+e1[2]);
					dos2.writeUTF(""+e1[0]);
					dos2.writeUTF(""+e1[1]);
					dos2.writeUTF(""+e1[2]);
					dos3.writeUTF(""+e1[0]);
					dos3.writeUTF(""+e1[1]);
					dos3.writeUTF(""+e1[2]);
					dos1.writeUTF(""+e2[0]);
					dos1.writeUTF(""+e2[1]);
					dos1.writeUTF(""+e2[2]);
					dos2.writeUTF(""+e2[0]);
					dos2.writeUTF(""+e2[1]);
					dos2.writeUTF(""+e2[2]);
					dos3.writeUTF(""+e2[0]);
					dos3.writeUTF(""+e2[1]);
					dos3.writeUTF(""+e2[2]);
					dos1.writeUTF(""+e3[0]);
					dos1.writeUTF(""+e3[1]);
					dos1.writeUTF(""+e3[2]);
					dos2.writeUTF(""+e3[0]);
					dos2.writeUTF(""+e3[1]);
					dos2.writeUTF(""+e3[2]);
					dos3.writeUTF(""+e3[0]);
					dos3.writeUTF(""+e3[1]);
					dos3.writeUTF(""+e3[2]);
				}
			}
		}

		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
