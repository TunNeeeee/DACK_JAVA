# **Quản lý hội thao sinh viên**

## Mô Tả
Hệ thống Quản Lý Hội Thao là một ứng dụng web full-stack được thiết kế để quản lý và hỗ trợ việc đăng ký và tổ chức các sự kiện thể thao. Xây dựng bằng Spring Boot cho backend và HTML/CSS/JavaScript thuần cho phần frontend cho frontend, hệ thống cho phép người dùng khám phá các sự kiện sắp diễn ra, đăng ký đội thi đấu, tải lên hình ảnh minh chứng chuyển khoản và quản lý việc tham gia sự kiện một cách dễ dàng.

- **Động lực** Động lực để phát triển dự án này xuất phát từ nhu cầu cần một nền tảng tiện lợi và hiệu quả để quản lý việc đăng ký và truyền thông giữa ban tổ chức và người tham gia các sự kiện thể thao.
- **Tại sao phát triển?** Dự án được xây dựng để giải quyết những thách thức trong việc tổ chức hội thao, chẳng hạn như quản lý đăng ký đội, xử lý minh chứng thanh toán và phối hợp giữa ban tổ chức và người tham gia. Sử dụng các công nghệ hiện đại, chúng tôi mong muốn tạo ra một giải pháp giúp đơn giản hóa các quy trình này.
- **Vấn đề giải quyết** Hệ thống giải quyết các vấn đề liên quan đến việc đăng ký thiếu tổ chức, xử lý thanh toán không hiệu quả và thiếu sự phối hợp giữa các bên tham gia.
- **Bài học** Qua dự án này, tôi đã học được cách tích hợp frontend (HTML/CSS/JavaScript thuần) với backend (Spring Boot), quản lý tải lên tệp, triển khai hệ thống xác thực người dùng và xử lý hệ thống vai trò đa người dùng (quản trị viên, người tham gia) trong một ứng dụng web full-stack có khả năng mở rộng.
---
## Mục Lục
- [Cài Đặt](#cài-đặt)
- [Cách Sử Dụng](#cách-sử-dụng)
- [Người Thực Hiện](#người-thực-hiện)
- [Tính Năng](#tính-năng)
---
## Cài Đặt
### Backend (ASP.NET Core)
#### Yêu Cầu
- Java 11 trở lên
- Maven
#### Các Bước
1. Clone repository bằng cách sao chép URL từ dự án và điều hướng đến terminal hoặc giao diện GitHub.
2. Mở thư mục backend trong IDE yêu thích và đảm bảo rằng Java và Maven được cấu hình chính xác.
3. Build và chạy Spring Boot để khởi động server backend.
### Frontend (HTML/CSS/JavaScript)
#### Yêu Cầu
- Trình duyệt hỗ trợ HTML5, CSS3 và JavaScript
- Editor (Visual Studio Code hoặc editor yêu thích)
#### Các Bước
1. Mở thư mục frontend và đảm bảo các file HTML, CSS, và JavaScript được liên kết đúng cách với API backend.
2. Mở tệp HTML chính trong trình duyệt để chạy ứng dụng.

---

# **Cách Sử Dụng**

Khi cả server backend và frontend đều đã chạy, ứng dụng có thể được truy cập qua trình duyệt tại địa chỉ http://localhost:8082. Dưới đây là một số hình ảnh minh họa các tính năng chính:
- **Trang đăng nhập**
![Screenshot 2024-06-03 151744](https://github.com/user-attachments/assets/a218cd74-5011-435c-a3da-10b1d1935b7c)
- **Trang chủ của sinh viên** 
![Screenshot 2024-06-03 152007](https://github.com/user-attachments/assets/b2ecf177-1156-4649-84e3-0b1b93d2669d)
- **Trang chủ của quản trị viên**
![Screenshot 2024-06-23 083422](https://github.com/user-attachments/assets/a23cd2a6-d923-4be8-8a8e-bbb9694659ed)
- **Trang đăng ký đội thi đấu**
![Screenshot 2024-06-03 152138](https://github.com/user-attachments/assets/82b379b6-2d75-4666-9d79-44efa5f4e041)
- **Giao diện trang quản lý lịch thi đấu**
![Screenshot 2024-06-18 175851](https://github.com/user-attachments/assets/d4b9e3ef-35c5-4f8f-ab80-5d3a48e9cff2)
- **Thêm trận đấu(Thủ công)**
![Screenshot 2024-06-18 003856](https://github.com/user-attachments/assets/16885b6a-1ad7-4203-9c81-8362c3e27d40)
- **Giao diện trang xem Bảng đấu**
![Screenshot 2024-06-23 083140](https://github.com/user-attachments/assets/3ebb9e57-650f-4f07-9167-0bd80362d02e)
- **Giao diện trang xem Lịch thi đấu - Kết quả**
![Screenshot 2024-06-23 083220](https://github.com/user-attachments/assets/9ab4bf8c-03b6-4f0c-b59c-bf96ab7d491e)
- **Trang quản lý thành tích**
![Screenshot 2024-06-23 085924](https://github.com/user-attachments/assets/fe768c31-a9b4-4483-ae53-8f31ef858b51)
---

## Người thực hiện

- **[Nguyen Dinh Tuan](https://github.com/TunNeeeee)** - Nhóm trưởng / Fullstack
- **[Phan Nguyen Tan Tai]** - Fullstack
- **[Nguyen Nhu Quynh])** - Front-end
---
## Tính Năng
- Đăng nhập/Đăng xuất
- Tìm kiếm sự kiện và lọc theo danh mục
- Carousel sự kiện hiển thị các sự kiện có sẵn
- Đăng ký đội thi đấu kèm tải lên minh chứng chuyển khoản
- Hệ thống xác minh email cho người tham gia
- Bảng quản trị sự kiện cho ban tổ chức
- Hủy đăng ký
- Sắp xếp cập nhật các cặp đấu và kết quả
- Cập nhật lại bxh bảng đấu và bảng xếp hạng tổng sau mỗi trận đấu
- In giấy chứng nhận tham gia

