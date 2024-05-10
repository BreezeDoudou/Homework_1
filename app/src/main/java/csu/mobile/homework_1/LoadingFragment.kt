package csu.mobile.homework_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView

class LoadingFragment : Fragment() {
    private var loadingAnimation: LottieAnimationView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_loading, container, false)
        loadingAnimation = view.findViewById(R.id.lottieAnimationView)
        // 启动加载动画
        startLoadingAnimation()
        // 模拟加载数据
        simulateDataLoading()
        return view
    }

    private fun startLoadingAnimation() {
        loadingAnimation.setVisibility(View.VISIBLE)
        loadingAnimation.playAnimation()
    }

    private fun stopLoadingAnimation() {
        loadingAnimation.cancelAnimation()
        loadingAnimation.setVisibility(View.GONE)
    }

    private fun simulateDataLoading() {
        // 模拟5秒后停止加载并展示列表
        loadingAnimation.postDelayed({ stopLoadingAnimation() }, 5000) // 5000 毫秒 = 5 秒
    }

    companion object {
        fun newInstance(): LoadingFragment {
            return LoadingFragment()
        }
    }
}