package net.hulyk.githubclient.feature

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.hulyk.githubclient.R.layout
import net.hulyk.githubclient.viewModelProvider
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        viewModel = viewModelProvider(viewModelFactory)

        viewModel.loading.observe(this, Observer { progressBar.isVisible = it })
        viewModel.repoInfo.observe(this, Observer { label.text = it })

        loadAllRepos.setOnClickListener { viewModel.loadAllRepoData() }
        loadEvenRepos.setOnClickListener { viewModel.loadEvenRepoData() }

    }

}
