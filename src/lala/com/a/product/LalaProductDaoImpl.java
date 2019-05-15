package lala.com.a.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lala.com.a.model.CartDto;
import lala.com.a.model.FestivalDto;
import lala.com.a.model.OrderedDto;
import lala.com.a.model.ProductDto;
import lala.com.a.product.LalaProductDao;

@Repository
public class LalaProductDaoImpl implements LalaProductDao {

	@Autowired
	SqlSession sqlSession;
	
	String ns = "Product.";

	//제품등록할때 축제검색
	@Override
	public List<FestivalDto> getFestivalList(String s_keyword) {
		return sqlSession.selectList(ns+"getFestivalList", s_keyword);
	}

	//제품등록
	@Override
	public boolean productWriteAf(ProductDto dto) {
		int n = sqlSession.insert(ns+"productWriteAf", dto);
		return n>0? true:false;
	}

	//파일업로드
	@Override
	public void uploadFile(FilePdsDto dto) {
		sqlSession.insert(ns+"uploadFile", dto);
	}

	//제품전체목록
	@Override
	public List<ProductDto> getProductList() {
		return sqlSession.selectList(ns+"getProductList");
	}

	//디테일
	@Override
	public ProductDto productDetail(int seq) {
		return sqlSession.selectOne(ns+"productDetail", seq);
	}

	//파일리스트
	@Override
	public List<FilePdsDto> getFileList(int seq) {
		return sqlSession.selectList(ns+"getFileList", seq);
	}

	//장바구니에 넣기
	@Override
	public boolean cartinsert(CartDto dto) {
		int n = sqlSession.insert(ns+"cartinsert", dto);
		return n>0? true:false;
	}

	@Override
	public List<CartDto> getCartList(CartDto dto) {
		// 장바구니 목록
		return sqlSession.selectList(ns+"getCartList", dto);
	}

	@Override
	public CartDto getProductSeq(CartDto dto) {
		// 물건담을때 장바구니에 이미있는건지 확인
		CartDto cdto = sqlSession.selectOne(ns+"getProductSeq", dto);
		System.out.println("daoimpl dto: " + dto.toString());
		//System.out.println("daoimpl cdto: " + cdto.toString());
		return cdto;
	}

	@Override
	public boolean updateMyCount(CartDto dto) {
		// 수량변경 (담는데 이미있을때)
		int n = sqlSession.update(ns+"updateMyCount", dto);
		
		return false;
	}

	@Override
	public CartDto getCart(int seq) {
		// 주문의 제품dto 하나씩 가져오기
		return sqlSession.selectOne(ns+"getCart", seq);
	}

	@Override
	public int orderedInsert(OrderedDto dto) {
		System.out.println("dao orderedInsert dto: " + dto.toString());
		// 주문결제시 주문자정보 저장
		
		//OrderedDto odto = new OrderedDto();
		
		//odto.setSeq(sqlSession.insert(ns+"orderedInsert", dto));
		//int seq = sqlSession.insert(ns+"orderedInsert", dto);
		sqlSession.insert(ns+"orderedInsert", dto);
		System.out.println("dao impl return seq: " + dto.getSeq());
		
		return dto.getSeq();
	}

	@Override
	public boolean updateCartOseq(CartDto dto) {
		//주문결제 후 장바구니의 oseq에 주문내역 seq를 저장
		int n = sqlSession.update(ns+"updateCartOseq", dto);
		return n>0? true:false;
	}

	@Override
	public void deleteFile(int seq) {
		// 파일삭제
		sqlSession.delete(ns+"deleteFile", seq);
	}

	@Override
	public FestivalDto getFestivalName(int seq) {
		// 축제seq로 축제dto가져오기 (수정에 씀)
		return sqlSession.selectOne(ns+"getFestivalName", seq);
	}

	@Override
	public boolean productUpdateAf(ProductDto dto) {
		// 제품수정
		int n = sqlSession.update(ns+"productUpdateAf", dto);
		return n>0? true:false;
	}
	
	
}

























