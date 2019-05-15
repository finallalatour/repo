package lala.com.a.product;

import java.util.List;

import lala.com.a.model.CartDto;
import lala.com.a.model.FestivalDto;
import lala.com.a.model.OrderedDto;
import lala.com.a.model.ProductDto;

public interface LalaProductDao {

	//제품등록할때 축제검색
	public List<FestivalDto> getFestivalList(String s_keyword);
	public FestivalDto getFestivalName(int seq); //축제seq로 축제dto가져오기 (수정에 씀)
	
	public boolean productWriteAf(ProductDto dto); //제품등록
	public boolean productUpdateAf(ProductDto dto); //제품수정
	public void uploadFile(FilePdsDto dto); //파일업로드
	public void deleteFile(int seq); //파일삭제
	
	public List<ProductDto> getProductList(); //제품전체목록
	
	//디테일
	public ProductDto productDetail(int seq); //제품디테일
	public List<FilePdsDto> getFileList(int seq); //파일리스트
	
	//장바구니
	public CartDto getProductSeq(CartDto dto); //물건담을때 장바구니에 이미있는건지 확인
	public boolean updateMyCount(CartDto dto); //수량변경 (담는데 이미있을때)
	public boolean cartinsert(CartDto dto);
	public List<CartDto> getCartList(CartDto dto); //장바구니 목록
	public CartDto getCart(int seq); //주문의 제품dto 하나씩 가져오기
	
	//주문
	public int orderedInsert(OrderedDto dto); //주문결제시 주문자정보 저장
	public boolean updateCartOseq(CartDto dto); //주문결제 후 장바구니의 oseq에 주문내역 seq를 저장
}














