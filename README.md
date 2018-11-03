# Boarding-House
>Boarding-House là phần mềm quản lý khu trọ giúp cho người chủ nhà trọ dễ dàng nắm bắt mọi thông tin, điều phối hoạt động dễ dàng, đồng thời tăng hiệu suất làm việc, các dịch vụ, chỉ số điện, nước, gas, tiền phòng được thực hiện chính xác, tránh những sai sót không đáng có. Bên cạnh đó, nó còn hỗ trợ cho khách thuê trọ có thể theo dõi thông tin phòng, các chí phí phải trả hàng tháng,...
## Tổng quát
#### Mô tả bài toán
1. Hoạt động thuê nhà
- Đối với khách hàng có nhu cầu ở phải báo trước cho phía nhà trọ (nhân viên/chủ trọ). Có hai hình thức đặt nhà trước; Gọi điện hoặc tới trực tiếp. Khách hàng cần khai báo chính xác thông tin cá nhân: Họ tên, CMND, số điện thoại, emai, ... khách hàng có thể đăng kí mọi dịch vụ trước và sau khi nhận phòng. Sau khi nhận đầy đủ thông tin khách hàng, nhân viên sẽ kiểm tra số phòng trống, đảm nhiệm việc đón khách, lập phiếu thuê sau đó giao phòng cho khách, bố trí khách thuê phòng và sử dụng các dịch vụ.
- Trước khi trả phòng khách báo trước cho phía nhà trọ cử người tới nhận và kiểm tra phòng. Sau đó sẽ lập hóa đơn thanh toán cho hách, khách hàng có thể thanh toán trực tiếp bằng tiền mặt hoặc qua thẻ.
2. Đăng ký sử dụng dịch vụ
- Khách hàng có nhu cầu sử dụng dịch vụ thì có thể đăng kí với nhà trọ. Sau đó sẽ lập phiếu đăng kí dịch vụ và báo cáo cho các phía liên quan để đáp ứng nhu cầu cho khách. Nếu có sự cố xảy ra thì báo cho bộ phận nhân viên có nhiệm vụ lập và đưa phiếu thu cho khách.
3. Lập báo cáo
- Hàng tháng người quản lí đăng nhập vào hệ thống bằng tài khoản của mình, lấy báo cáo từ nhân viên bao gồm: báo cáo doanh thu, báo cáo tình trạng phòng, danh sách khách thuê phòng.... hoặc có thể thống kê bất cứ khi nào cần.
## Phân tích thiết kế hệ thống
#### Đối tượng, ca sử dụng
- Quản lý: Là người quản lý, điều hành, quản lý các đoạn động trong khu trọ
- Khách hàng: Là người có nhu cầu thuê phòng, sử dụng dịch vụ
#### Use case
- Quản lý thuê phòng (Đặt phòng, hủy đặt phòng, trả phòng, kiểm tra phòng trống, lập phiếu thuê phòng)
- Quản lý khách hàng (Thêm, sửa, xóa)
- Lập hóa đơn
- Lập báo cáo (Báo cáo doanh thu, tình trạng phòng, danh sách khách thuê phòng)
- Quản lý phòng (Thêm, sửa, xóa phòng)
- Quản lý dịch vụ (Thêm, sửa, xóa dịch vụ)
- Quản lý thuê dịch vụ (Đăng ký, hủy đăng ký sử dụng dịch vụ)
- Quản lý tài khoản (Đăng nhập, kiểm tra tài khoản, thêm, sửa, xóa tài khoản)
#### Đặc tả ca sử dụng
1. Quản lý thuê phòng   
*Ca này được dùng khi có khách thuê phòng*
- Kiểm tra danh sách phòng  trống
- Khách chọn phòng muốn thuê, nhân viên lựa chọn chức năng lập phiếu thuê
- Khách hàng cung cấp đầy đủ thông tin để điền vào phiếu thuê
- Tạo phiếu thuê, in, sao lưu giao cho mỗi bên 1 bản
- Nếu khách đồng ý nhận phiếu thuê, đưa khách đi xem, nếu ko có thể đổi phòng hoặc ko thuê nữa
2. Quản lý phòng    
*Ca này được sử dụng để quản lý phòng cho thuê*
- Quản lí đăng nhập vào hệ thống bằng tài khoản của mình, lựa chọn chức năng phù hợp với yêu cầu
- Nếu chọn thêm hoặc sửa thông tin phòng thì sau khi nhập điều chỉnh đầy đủ thông tin cần phải click vào cập nhật thông tin để đẩy lên database
- Nếu lựa chọn xóa thì yêu cầu xác nhận lại bằng cách yêu cầu nhập mã phòng cần xóa
3. Quản lý khách hàng   
*Ca này được sử dụng để quản lý thông tin về khách thuê nhà, sử dụng dịch vụ*
- Ca sử dụng được khi muốn thêm khách hàng hoặc có sự thay đổi về thông tin khách hàng, hoặc xóa thông tin và tìm kiếm thông tin
- Quản lý đăng nhập vào hệ thống bằng tài khoản của mình, lựa chọn chức năng phù hợp với yêu cầu
- Nếu chọn thêm hoặc sửa thông tin phòng thì sau khi nhập điều chỉnh đầy đủ thông tin cần phải click vào cập nhật thông tin để đẩy lên database
- Nếu lựa chọn xóa thì yêu cầu xác nhận lại bằng cách yêu cầu nhập mã khách hàng cần xóa
- Nếu chọn tìm kiếm thì cần nhập thông tin cần tìm kiếm
4. Quản lý tài khoản    
*Ca này được sử dụng để quản lý thông tin về quyền và người sử dụng hệ thống    
Ca sử dùng được khi muốn thêm tài khoản hoặc có sự thay đổi về thông tin tài khoản,xem hoặc xóa thông tin về tài khoản*
- Quản lý đăng nhập vào hệ thống bằng tài khoản có quyền root của mình, lựa chọn chức năng phù hợp với yêu cầu
- Nếu chọn thêm hoặc sửa thông tin phòng thì sau khi nhập điều chỉnh đầy đủ thông tin cần phải click vào cập nhật thông tin để đẩy lên database
- Nếu lựa chọn xóa thì yêu cầu xác nhận lại bằng cách yêu cầu nhập mã xác khách hàng cần xóa
- Người có quyền root có thể xem chi tiết về tài khoản, về quyền hạn của các tài khoản khác
5. Lập hóa đơn/hợp đồng   
*Ca sử dụng này cho phép lập và in hóa đơn tính tiền, chi phí mà khách phải trả   
Ca được sử dùng khi quản lý chọn chức năng đăng nhập hóa đơn*
- Quản lí nhập đầy đủ thông tin về khách thuê , phòng được thuê, số phòng thuê, người lập hóa đơn, ngày thuê/trả và các giấy tờ liên  quan, hệ thống sẽ tính tiền dựa vào giá phòng, thời gian thuê phòng và số dịch vụ đã sử dụng
- Quản lí sẽ in sao lưu 1 hóa đơn, giữ lại 1 bản và giao 1 bản cho khách
6. Lập báo cáo    
*Ca sử dụng cho phép người quản trị lấy thông tin, báo cáo từ hệ thống, tổng hợp báo cáo hàng tháng hoặc báo cáo khi có yêu cầu về doanh thu, tình trạng phòng hoặc danh sách khách thuê*
- Quản lí đăng nhập vào hệ thống bằng tài khoản có quyền root của mình, lựa chọn chức năng thống kê
- Lựa chọn các tổng hợp, có thể theo tháng, tuần hoặc theo thời gian
- Quản lý có thể chọn và in báo cáo
7. Quản lý dịch vụ    
*Ca này dùng để quản lý dịch vụ có trong khu trọ*
- Quản lý đăng nhập vào hệ thống bằng tài khoản của mình, lựa chọn chức năng phù hợp với yêu cầu
- Nếu chọn thêm hoặc sửa thông tin dịch vụ thì sau khi nhập điều chỉnh đầy đủ thông tin cần phải click vào cập nhật thông tin để đẩy lên database
- Nếu lựa chọn xóa thì yêu cầu xác nhận lại bằng cách yêu cầu nhập mã xác dịch vụ cần xóa
- Nếu có sai sót trong quá trình nhập hệ thống phải có thông báo trở lại
8. Quản lý thuê dịch vụ   
*Ca sử dụng để quản lí việc cho thuê dijch vụ có trong khu trọ*
- Khi khách có nhu cầu sẽ liên hệ quản lí
- Quản lý tìm kiếm về dịch vụ mà khách yêu cầu trong hệ thống dịch vụ
	Lập phiếu đăng kí sử dụng cho khách
- Sau khi sử dụng dịch vụ, lập phiếu thu, in và sao khi giao cho khách hàng. Chi phí cho dịch vụ sẽ được tính vào tổng tiền trong hóa đơn thanh toán khi trả phòng
