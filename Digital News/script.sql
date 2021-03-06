USE [Digital]
GO
/****** Object:  Table [dbo].[Articles]    Script Date: 3/1/2020 7:25:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Articles](
	[id] [int] NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[image] [nvarchar](100) NOT NULL,
	[content] [nvarchar](max) NOT NULL,
	[date] [datetime] NOT NULL,
	[author] [nvarchar](100) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Articles] ([id], [title], [image], [content], [date], [author]) VALUES (1, N'Making security feeds smaster via machine learning

', N'i1.jpg', N'In today age of surveilance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report. It is increasingly clear that the watchmen are having trouble watching.This is where Singapore-based Vi Dimensions hopes to help, by indentifying anomalies to alert human operators that a second look is needed.</br></br></br> While the security indestry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief excutive officer Raymond Looi. Video analytics has been in the market for the last 10 years, but the ways they have been doing it is not very efficent, using rule-based analytics. This requires you know what to look out for, he says, in a conversation with Digital News Asia(DNA) in Singapore recently. We felt that there was a gap in the industry in how they applied automatio to camera a and with the proliferation of surveilance cameras and vast amounts of data being generated. ', CAST(N'2019-12-12 00:00:00.000' AS DateTime), N'Benjiamin Chef')
INSERT [dbo].[Articles] ([id], [title], [image], [content], [date], [author]) VALUES (2, N'Malaysian healthtech startup doctorroncall helps government to combat covid-19

', N'i1.jpg', N'To address the growing number of public queries on the COVID-19 disease and correcting misinformation, the Ministry of Health in partnership with healthtech startup, DoctorOnCall, have established a virtual health advisory portal in Bahasa Malaysia, the national language.</br></br>This medium, is the first of its kind initiated by a Government in the region. Malaysians can access this for free from anywhere, seven days a week, between 8.30am - 5.00pm via www.moh.gov.my or www.doctoroncall.com.my/coronavirus.</br></br>20 of the Ministry’s Family Medicine Specialist together with our digital team are on standby, to ensure this service is ready and able to deal with the influx of public queries, said Hazwan Najib, cofounder, DoctorOnCall.
', CAST(N'2020-02-20 10:31:00.000' AS DateTime), N'Digital News Asia')
INSERT [dbo].[Articles] ([id], [title], [image], [content], [date], [author]) VALUES (3, N'Indonesian AI Startup, Eureka.Ai Closes US$20m Series B Round', N'i1.jpg', N'Eureka, an AI enterprise software company which counts a credit score system as its flagship product and claims a collective mobile subscriber base of over a billion customers, announced on Tues that it had closed its Series B fundraising round of US$20 million (RM83 million). Established in 2017 by a former head of McKinsey & Co’s Indonesian office, Benjamin Soemartopo, the startup leverages on AI and telco analytics to power mobile operator and enterprise partnerships. Specifically, it unlocks the data that telcos hold, enabling the monetisation of this data through products and services that deliver insights, risk scoring and customer engagement.', CAST(N'2020-01-03 23:01:01.000' AS DateTime), N'Digital News Asia')
INSERT [dbo].[Articles] ([id], [title], [image], [content], [date], [author]) VALUES (4, N'OpenSys Launches BuySolar, Malaysia’s First One-Stop Online Solar Marketplace', N'i1.jpg', N'Malaysia is a sunny country. Barring a few rainy seasons, the nation has relatively high irradiation levels, which makes for a good spot to harness solar energy. Yet there are barriers in place that deter both consumers and businesses from setting up their own solar panels on their rooftops.</br></br>Cost is an issue, which makes it hard for people to justify spending thousands to save on electricity. There’s also the problem with financing – where do you get them? What financial institution offers them? More crucially, how does one get around to find the right solar provider to get things set up?</br></br>buySolar aims to solve all that. Created by OpenSys Technologies Sdn Bhd (a subsidiary of OpenSys Bhd), buySolar positions itself as Malaysia’s first “one-stop online marketplace”, with the goal of providing consumers and businesses a platform to get the solar products and services needed under one roof.', CAST(N'2020-03-02 12:05:15.000' AS DateTime), N'Tan Jee Yee')
