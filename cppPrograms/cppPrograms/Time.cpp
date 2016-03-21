//#include<iostream>
//#include<iomanip>
//#include "Time.h"
//
//using namespace std;
//
//Time::Time()
//{
//	hour = minute = second = 0;
//}
////To validate the hour,minutes and seconds
//void Time::setTime(int h, int m, int s)
//{
//	hour = (h >= 0 && h < 24) ? h : 0;
//	minute = (m >= 0 && m < 60) ? m : 0;
//	second = (s >= 0 && s < 60) ? s : 0;
//}
//
////To printUniversal time format HH:MM:SS
//void Time::printUniversal()
//{
//	cout << setfill('0') << setw(2) << hour << ":" << setw(2) << minute << ":" << setw(2) << second << endl;
//}
//
////To printStandard time fromat HH:MM:SS and AM or PM
//void Time::printStandard()
//{
//	cout << ((hour == 0 || hour == 12) ? 12 : hour % 12) << ":" << setfill('0') << setw(2) << minute <<":"<< setw(2) << second <<" "<<
//		((hour < 12) ? "AM" : "PM" )<< endl;
//}