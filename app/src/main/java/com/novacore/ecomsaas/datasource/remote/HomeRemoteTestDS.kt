package com.novacore.ecomsaas.datasource.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.novacore.ecomsaas.db.entity.ProductEntity
import com.novacore.ecomsaas.network.response.HomeResponse
import com.novacore.ecomsaas.util.Result
import kotlinx.coroutines.delay

class HomeRemoteTestDS(): RemInterface {
    val productNames  = listOf<String>("Tecno Camon 12", "iPhone 11 pro Max", "Kobv Pots","Long Man Tables","YSL shirt", "Luiz V shirt", "Nike Sneakers","Kataga Drone","Pes 2020","Fifa 2019","Air max Sneakers","Arabian Oud","Draggon","Cute Puppies","Venza","Mercedis", "Iron","Nike AC", "Puma Shoe", "Solar Board","Cassava Flakes", "Orange Fruit Juice", "Toilet Sits","PS4 Console","Xbox 360", "VR Camera")
    val parentId = listOf<String>("37578ds","fuy67890","87989ssjgfy","xvfyfw876","t6xbouigj","syvw6uij9","xvyfd64","jgft5678","hguiy689","ngf654","it567h","vfr7hi987","nbuy789","vcfde32","nbgr56sc","bgt5fgvbs","1qazxcj","bgtyuik876","bgtfvcde","67890oiuf","hgfr567i987","jhgfryui987","nytfr456789876543","vgt567890987654","vfre456789iuhg","nbgtf665rw")
    val productImg = listOf<String>("https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/R/H/118566_1571905766.jpg", "https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/S/R/59340_1582062066.jpg","https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/F/C/126032_1551807866.jpg","https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/O/E/92910_1570894747.jpg","https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/V/W/147974_1548842437.jpg")
    val discounts = listOf<Int>(0,5,19,10,12,60,90,4,39,12,66,54,30,32)
    val price = listOf<Int>(1000,5000,19000,1200,900,78000,54000,4000,1000000,3500,66000,76000,95000,330000,21000)
    override suspend fun fetchHomeRemData() : Result< HomeResponse>{
        delay(2000)
        val myList: MutableList<ProductEntity> = arrayListOf()
        for(i in 1..200){
            val item = ProductEntity(
                productName = productNames.random(),
                productId = (Math.random()*260+i+productNames.random().length).toString(),
                mainParentId = parentId.random(),
                subParentId = (Math.random()+i).toString(),
                productImg = productImg.random(),
                productQty = i,
                productDescription = "Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o! Mad o Mad o! Mad o! Mad o!Mad o! Mad o! Mad o!Mad o! Mad o! Mad o!Mad o! Mad o! Mad o!Mad o! Mad o! Mad o!Mad o! Mad o! Mad o!Mad o! Mad o! Mad o!!"+i,
                productDiscount = discounts.random(),
                dbsn = i.toLong(),
                productTraderId = (Math.random()*870+i+productNames.random().length).toString(),
                productPrice = price.random().toDouble(),
                productSlide_imgs = "https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/R/H/118566_1571905766.jpg*vbvx*https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/S/R/59340_1582062066.jpg"
            )
            myList.add(item)
        }
        val response = HomeResponse(1, myList as List<ProductEntity>)
        return Result.Success(response)
    }
}