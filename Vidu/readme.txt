Backend: building/backend
Frontend:building/frontend

Mô tả: frontend gửi tên cuộc họp (session) cho backend sau đó backend dùng session đó tạo connect cho cuộc họp (nếu tạo rồi thì thôi)
 sau đó lấy token ra và gửi lại cho frontend 

Hiện tại backend mới chỉ build service cho việc get-token, bỏ qua mọi đăng nhập và mặc định role là publisher,
service được build tại SessionController

Frontend đã nhận được token, đã truy cập vào camera của laptop và laptop cũng xác nhận nhưng không hiển thị screen. 
Kiểm tra trên frontend thì thấy tại dòng 145-148 không setState nên không hiển thị screen

Source backend: mvc-java và Javascript-java
Source frontend: insecure-react
Link hỏi đáp vidu: OpenVidu - openvidu webrtc videoconference web apps mobile ipcamera realtime

Phiên bản sử dụng: 2.17.0
